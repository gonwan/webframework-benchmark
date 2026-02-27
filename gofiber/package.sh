#!/usr/bin/bash

go build gofiler_server.go
docker build -t gonwan/gofiber_server:1.0.0 -t gonwan/gofiber_server:latest .
