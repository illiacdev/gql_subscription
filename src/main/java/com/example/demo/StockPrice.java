package com.example.demo;

public class StockPrice {
    private String symbol;
    private Double price;

    public StockPrice(String symbol, Double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getPrice() {
        return price;
    }
}
