package com.colombo.stockexchange.service;

import com.colombo.stockexchange.entity.Stock;

/**
 * created by Diluni
 * on 12/19/2022
 */
public interface StockService {
    Boolean add(Stock stock);

    Boolean update(Stock stock);
}
