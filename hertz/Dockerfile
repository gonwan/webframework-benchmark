FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY hertz_server ./
ENV GOMAXPROCS=4
ENTRYPOINT [ "./hertz_server" ]
