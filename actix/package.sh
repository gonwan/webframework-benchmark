#!/usr/bin/bash

cargo clean
cargo build --release
docker build -t gonwan/actix_server:1.0.0 -t gonwan/actix_server:latest .
