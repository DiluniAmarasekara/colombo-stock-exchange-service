package com.colombo.stockexchange.dto;

import lombok.Data;

/**
 * created by Diluni
 * on 12/31/2022
 */
@Data
public class TradeDto {

    private Long stockId;

    private Long tradeId;

    private Double individualPrice;

    private Integer quantity;

    private Long transactionId;

    public TradeDto() {
    }

    public TradeDto(Long stockId, Long tradeId, Double individualPrice, Integer quantity) {
        this.stockId = stockId;
        this.tradeId = tradeId;
        this.individualPrice = individualPrice;
        this.quantity = quantity;
    }
}
