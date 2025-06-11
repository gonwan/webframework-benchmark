package com.gonwan.benchmark;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

    @GetMapping(value = "/text", produces = MediaType.TEXT_HTML_VALUE)
    public String text() {
        return "Hello, World!";
    }

    @GetMapping("/json")
    public Map<String, String> json() {
        return Collections.singletonMap("message", "Hello, World!");
    }

}

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
public class SpringWebMvcApplication {

    /**
     * It's very hard to remove the Date Http header in Tomcat, since it's hardcoded.
     * See: {@link org.apache.coyote.http11.Http11Processor#prepareResponse()}
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringWebMvcApplication.class, args);
    }

}
