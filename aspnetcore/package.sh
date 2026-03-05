#!/usr/bin/bash

rm -rf app
dotnet publish -c Release -o app
docker build -t gonwan/aspnetcore_server:1.0.0 -t gonwan/aspnetcore_server:latest .
