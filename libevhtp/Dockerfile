FROM ubuntu:24.04 AS builder
RUN apt-get update && apt-get install -y build-essential libssl-dev libevent-dev libevhtp-dev
WORKDIR /app
COPY libevhtp_server.c ./
RUN gcc -O2 libevhtp_server.c -o libevhtp_server -levent -levhtp
RUN mkdir -p ./lib &&  \
    ldd libevhtp_server | grep "=> /" | awk '{print $3}' | xargs -I '{}' cp -L '{}' ./lib

FROM ubuntu:24.04
WORKDIR /app
COPY --from=builder /app/libevhtp_server /app
COPY --from=builder /app/lib/* /app/lib/
ENV LD_LIBRARY_PATH="./lib"
ENTRYPOINT [ "./libevhtp_server" ]
