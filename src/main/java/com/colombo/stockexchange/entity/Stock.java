package com.colombo.stockexchange.entity;

import com.colombo.stockexchange.util.MarketType;
import com.colombo.stockexchange.util.StockSymbol;
import lombok.Data;

import javax.persistence.*;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    private String stockName;

    @Enumerated(EnumType.ORDINAL)
    private StockSymbol stockSymbol;

    private Double currentPrice;

    private String change;

    private Double buyingPrice;

    private Double sellingPrice;

    private Double high52;

    private Double low52;

    @Enumerated(EnumType.ORDINAL)
    private MarketType marketType;

    public Stock() {
    }

    public Stock(String stockName, StockSymbol stockSymbol, Double currentPrice, String change, Double buyingPrice, Double sellingPrice, Double high52, Double low52, MarketType marketType) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.currentPrice = currentPrice;
        this.change = change;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.high52 = high52;
        this.low52 = low52;
        this.marketType = marketType;
    }
}
