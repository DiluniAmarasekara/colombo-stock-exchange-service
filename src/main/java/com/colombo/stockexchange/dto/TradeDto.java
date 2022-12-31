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

    private String buySell;

    private Long userId;
}
