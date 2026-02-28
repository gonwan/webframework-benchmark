// g++ -O2 drogon_server.cpp -o drogon_server -I/usr/include/jsoncpp -ljsoncpp -ltrantor -ldrogon
// ~33w/s, slightly slower than go-gin server. No difference after disabling server & date headers...
#include <drogon/drogon.h>
using namespace drogon;


int main()
{
    app().registerHandler(
        "/text",
        [](const HttpRequestPtr &,
           std::function<void(const HttpResponsePtr &)> &&callback) {
            auto resp = HttpResponse::newHttpResponse();
            resp->setBody("Hello, World!");
            callback(resp);
        },
        {Get});
    app().registerHandler(
        "/json",
        [](const HttpRequestPtr &,
           std::function<void(const HttpResponsePtr &)> &&callback) {
            Json::Value json;
            json["message"] = "Hello, World!";
            auto resp = HttpResponse::newHttpJsonResponse(json);
            callback(resp);
        },
        {Get});
    LOG_INFO << "drogon server running at 8099";
    fflush(stdout);  /* flush for docker logs */
    app().addListener("0.0.0.0", 8099)
        .setThreadNum(4)
        .setMaxConnectionNum(10000)
        .enableServerHeader(false)
        .enableDateHeader(false)
        //.enableRunAsDaemon()
        .run();
}
