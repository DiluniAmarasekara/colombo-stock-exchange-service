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
}
