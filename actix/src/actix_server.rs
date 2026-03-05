use actix_web::{get, web, App, HttpServer, Responder};
use serde_json::json;

#[get("/text")]
async fn text_response() -> impl Responder {
    "Hello, World!"
}

#[get("/json")]
async fn json_response() -> impl Responder {
    web::Json(json!({
        "message": "Hello, World!"
    }))
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    println!("Actix server staring at :8099...");
    /* date header cannot be removed in actix */
    HttpServer::new(|| {
        App::new()
            .service(text_response)
            .service(json_response)
    })
    .workers(4)
    .bind(("0.0.0.0", 8099))?
    .run()
    .await
}
