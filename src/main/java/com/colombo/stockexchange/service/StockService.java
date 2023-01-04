package com.colombo.stockexchange.service;

import com.colombo.stockexchange.dto.StockDto;
import com.colombo.stockexchange.entity.Stock;

import java.util.List;

/**
 * created by Diluni
 * on 12/19/2022
 */
public interface StockService {
    Boolean add(StockDto stockDto);

    Boolean update(StockDto stockDto);

    List<Stock> getAll();
}
