FROM ubuntu:24.04 AS builder
RUN apt-get update && apt-get install -y build-essential libboost-dev
WORKDIR /app
COPY beast_server.cpp ./
RUN g++ -O2 beast_server.cpp -o beast_server
RUN mkdir -p ./lib &&  \
    ldd beast_server | grep "=> /" | awk '{print $3}' | xargs -I '{}' cp -L '{}' ./lib

FROM ubuntu:24.04
WORKDIR /app
COPY --from=builder /app/beast_server /app
COPY --from=builder /app/lib/* /app/lib/
ENV LD_LIBRARY_PATH="./lib"
ENTRYPOINT [ "./beast_server" ]
