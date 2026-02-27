#!/usr/bin/bash

gcc -O2 libevhtp_server.c -o libevhtp_server -levent -levhtp
docker build -t gonwan/libevhtp_server:1.0.0 -t gonwan/libevhtp_server:latest .
