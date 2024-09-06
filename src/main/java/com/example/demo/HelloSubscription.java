package com.example.demo;

import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class HelloSubscription {
    private final HelloService helloService;

    public HelloSubscription(HelloService helloService) {
        this.helloService = helloService;
    }

     @SubscriptionMapping
     public Flux<String> hello() {
         return helloService.getHelloStream();
     }
}


