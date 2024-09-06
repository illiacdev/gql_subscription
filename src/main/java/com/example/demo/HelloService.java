package com.example.demo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class HelloService {

    public Flux<String> getHelloStream() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(count -> "Hello " + count);
    }
}

