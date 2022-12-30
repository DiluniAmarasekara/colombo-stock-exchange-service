package com.colombo.stockexchange.service;

import com.colombo.stockexchange.dto.TradeDto;
import com.colombo.stockexchange.entity.Trade;

import java.util.List;

/**
 * created by Diluni
 * on 12/31/2022
 */
public interface TradeService {
    Boolean buy(TradeDto tradeDto);

    List<Trade> getAllSell();
}
