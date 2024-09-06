package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class StockPriceController {
    private final StockPricePublisher stockPricePublisher;

    public StockPriceController(StockPricePublisher stockPricePublisher) {
        this.stockPricePublisher = stockPricePublisher;
    }

    @SubscriptionMapping
    public Flux<StockPrice> stockPriceUpdates(@Argument String symbol) {
        return Flux.from(stockPricePublisher.getStockPricePublisher())
                .filter(stockPrice -> stockPrice.getSymbol().equals(symbol));
    }
}
