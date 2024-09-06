package com.example.demo;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class ControllerApp {
    @QueryMapping
    Mono<String> hello() {
        return Mono.just("Hello, Spring GraphQL!");
    }
}
