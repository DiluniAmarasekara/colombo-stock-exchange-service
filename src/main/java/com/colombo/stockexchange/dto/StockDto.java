package com.colombo.stockexchange.dto;

import com.colombo.stockexchange.util.MarketType;
import com.colombo.stockexchange.util.StockSymbol;
import lombok.Data;

/**
 * created by Diluni
 * on 1/4/2023
 */
@Data
public class StockDto {
    private Long stockId;
    private String stockName;
    private StockSymbol stockSymbol;
    private Double currentPrice;
    private String change;
    private Double buyingPrice;
    private Double sellingPrice;
    private Double high52;
    private Double low52;
    private MarketType marketType;

    public StockDto() {
    }
}
