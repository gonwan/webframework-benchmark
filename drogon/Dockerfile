FROM ubuntu:24.04 AS builder
RUN apt-get update && apt-get install -y build-essential libjsoncpp-dev libtrantor-dev libdrogon-dev
WORKDIR /app
COPY drogon_server.cpp ./
RUN g++ -O2 drogon_server.cpp -o drogon_server -I/usr/include/jsoncpp -ljsoncpp -ltrantor -ldrogon
RUN mkdir -p ./lib &&  \
    ldd drogon_server | grep "=> /" | awk '{print $3}' | xargs -I '{}' cp -L '{}' ./lib

FROM ubuntu:24.04
WORKDIR /app
COPY --from=builder /app/drogon_server /app
COPY --from=builder /app/lib/* /app/lib/
ENV LD_LIBRARY_PATH="./lib"
ENTRYPOINT [ "./drogon_server" ]
