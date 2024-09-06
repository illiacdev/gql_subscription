package com.example.demo;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
public class StockPricePublisher {
    private FluxSink<StockPrice> stockPriceStream;
    private final Flux<StockPrice> stockPriceFlux;

    public StockPricePublisher() {
        this.stockPriceFlux = Flux.create(emitter -> this.stockPriceStream = emitter);
    }

    public void publishStockPrice(StockPrice stockPrice) {
        if (stockPriceStream != null) {
            stockPriceStream.next(stockPrice);
        }
    }

    public Publisher<StockPrice> getStockPricePublisher() {
        return stockPriceFlux;
    }
}
