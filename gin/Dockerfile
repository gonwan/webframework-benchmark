FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY gin_server ./
ENV GOMAXPROCS=4
ENTRYPOINT [ "./gin_server" ]
