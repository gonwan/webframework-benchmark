FROM alpine:3.22
RUN apk add --no-cache libc6-compat
WORKDIR /app
COPY gofiber_server ./
ENV GOMAXPROCS=4
ENTRYPOINT [ "./gofiber_server" ]
