#!/usr/bin/bash

go build hertz_server.go
docker build -t gonwan/hertz_server:1.0.0 -t gonwan/hertz_server:latest .
