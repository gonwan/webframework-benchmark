package com.gonwan.benchmark;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;


@RestController
class HelloController {

    @GetMapping(value = "/text", produces = MediaType.TEXT_PLAIN_VALUE)
    public String text() {
        return "Hello, World!";
    }

    @GetMapping("/json")
    public Map<String, String> json() {
        return Collections.singletonMap("message", "Hello, World!");
    }

}

/* Do not add additional overhead to the default configuration */
//@Component
class ContentLengthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, responseWrapper);
        responseWrapper.copyBodyToResponse();
    }
}

@SpringBootApplication
public class SpringWebMvcUndertowApplication {

    @Bean
    public UndertowBuilderCustomizer undertowBuilderCustomizer() {
        return new UndertowBuilderCustomizer() {
            @Override
            public void customize(Undertow.Builder builder) {
                builder.setServerOption(UndertowOptions.ALWAYS_SET_DATE, false);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebMvcUndertowApplication.class, args);
    }

}
