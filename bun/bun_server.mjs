const isPrimary = process.env.BUN_SERVER_MAIN === "true";

if (isPrimary) {
    for (let i = 0; i < 4; i++) {
        Bun.spawn({
            cmd: [ "bun", "bun_server.mjs" ],
            env: {...process.env, BUN_SERVER_MAIN: "false" },
            stdout: "inherit",
            stderr: "inherit",
        });
    }
} else {
    const server = Bun.serve({
        port: 8099,
        reusePort: true,
        fetch(req) {
            const url = new URL(req.url);
            let response;
            if (url.pathname === "/text") {
                response = new Response("Hello, World!");
            } else if (url.pathname === "/json") {
                response = Response.json({ message: "Hello, World!" });
            } else {
                response = new Response("Not Found", { status: 404 });
            }
            /* date header cannot be removed, since it is automatically added by the underlying uws library. */
            response.headers.delete("Connection");
            return response;
        },
    });
    console.log(`Bun worker ${process.pid} listening on ${server.url}`);
}
