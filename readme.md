## Benchmark for web frameworks

```bash
# benchmarking plaintext
$ wrk -c 1000 -t 10 -d 30s http://127.0.0.1:90xx/text
```

### Environment
- Server: 4C docker
- Client: 12C host machine
