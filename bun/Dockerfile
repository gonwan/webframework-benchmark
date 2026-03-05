FROM node:24-alpine
RUN npm install bun@1.3.10 -g
WORKDIR /app
COPY bun_server.mjs ./
ENV BUN_SERVER_MAIN=true
ENTRYPOINT [ "bun", "./bun_server.mjs" ]
