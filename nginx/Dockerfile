FROM nginx:1.28-alpine
RUN sed -i -E 's/^worker_processes\s+(auto|[0-9]+);/worker_processes 4;/g' /etc/nginx/nginx.conf
COPY nginx_http.conf /etc/nginx/conf.d/
