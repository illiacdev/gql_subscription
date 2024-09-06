package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SimulatedStockPriceUpdater {
    private final StockPricePublisher stockPricePublisher;
    private final Random random = new Random();

    public SimulatedStockPriceUpdater(StockPricePublisher stockPricePublisher) {
        this.stockPricePublisher = stockPricePublisher;
    }

    @Scheduled(fixedRate = 1000)
    public void updateStockPrice() {
        String[] symbols = {"AAPL", "GOOGL", "MSFT"};
        String symbol = symbols[random.nextInt(symbols.length)];
        double price = 100 + random.nextDouble() * 100;

        StockPrice stockPrice = new StockPrice(symbol, price);
        stockPricePublisher.publishStockPrice(stockPrice);
    }
}
