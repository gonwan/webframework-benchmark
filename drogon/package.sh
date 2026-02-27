#!/usr/bin/bash

g++ -O2 drogon_server.cpp -o drogon_server -I/usr/include/jsoncpp -ljsoncpp -ltrantor -ldrogon
docker build -t gonwan/drogon_server:1.0.0 -t gonwan/drogon_server:latest .
