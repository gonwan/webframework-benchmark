package com.gonwan.benchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
class HelloController {

    @GetMapping(value = "/text", produces = MediaType.TEXT_HTML_VALUE)
    public String text() {
        return "Hello, World!";
    }

    @GetMapping("/json")
    public Map<String, String> json() {
        return Collections.singletonMap("message", "Hello, World!");
    }

}

@SpringBootApplication
public class SpringWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxApplication.class, args);
    }

}
