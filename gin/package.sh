#!/usr/bin/bash

go build gin_server.go
docker build -t gonwan/gin_server:1.0.0 -t gonwan/gin_server:latest .
