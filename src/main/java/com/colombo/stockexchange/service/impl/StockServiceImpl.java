package com.colombo.stockexchange.service.impl;

import com.colombo.stockexchange.entity.Stock;
import com.colombo.stockexchange.repository.StockRepository;
import com.colombo.stockexchange.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Service
public class StockServiceImpl implements StockService {
    Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    @Override
    public Boolean add(Stock stock) {
        try {
            stockRepository.saveAndFlush(stock);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Boolean update(Stock stock) {
        try {
            if (stockRepository.findById(stock.getStockId()).isPresent()) {
                Stock stockObj = new Stock(stock.getStockName(), stock.getStockSymbol(), stock.getCurrentPrice(), stock.getChange(),
                        stock.getBuyingPrice(), stock.getSellingPrice(), stock.getHigh52(), stock.getLow52(), stock.getMarketType());

                stockRepository.saveAndFlush(stockObj);
            }
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

}
