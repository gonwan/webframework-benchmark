FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY hertz_server ./
ENTRYPOINT [ "./hertz_server" ]
