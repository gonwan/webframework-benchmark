FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY gin_server ./
ENTRYPOINT [ "./gin_server" ]
