import cluster from 'node:cluster';
import { createServer } from 'node:http';


/* pm2 is not used, since it has performance overhead. */
if (cluster.isPrimary) {
    for (let i = 0; i < 4; i++) {
        cluster.fork();
    }
} else {
    const server = createServer((req, res) => {
        res.sendDate = false;
        res.removeHeader('Connection');
        if (req.url === '/text') {
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end('Hello, World!');
        } else if (req.url === '/json') {
            res.writeHead(200, { 'Content-Type': 'application/json' });
            res.end(JSON.stringify({ message: 'Hello, World!' }));
        } else {
            res.writeHead(404, { 'Content-Type': 'text/plain' });
            res.end('404 Not Found');
        }
    });
    server.listen(8099, () => {
        console.log(`Node worker ${process.pid} running at http://localhost:8099/`);
    });
}
