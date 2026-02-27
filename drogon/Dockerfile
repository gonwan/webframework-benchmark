FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY drogon_server ./
ENTRYPOINT [ "./drogon_server" ]
