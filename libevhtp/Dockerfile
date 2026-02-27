FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY libevhtp_server ./
ENTRYPOINT [ "./libevhtp_server" ]
