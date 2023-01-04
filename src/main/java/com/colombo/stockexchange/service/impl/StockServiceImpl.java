package com.colombo.stockexchange.service.impl;

import com.colombo.stockexchange.dto.StockDto;
import com.colombo.stockexchange.entity.Stock;
import com.colombo.stockexchange.repository.StockRepository;
import com.colombo.stockexchange.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Boolean add(StockDto stockDto) {
        try {
            Stock stock = new Stock(stockDto.getStockName(), stockDto.getStockSymbol(), stockDto.getCurrentPrice(), stockDto.getChange(),
                    stockDto.getBuyingPrice(), stockDto.getSellingPrice(), stockDto.getHigh52(), stockDto.getLow52(), stockDto.getMarketType());
            stockRepository.saveAndFlush(stock);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Boolean update(StockDto stockDto) {
        try {
            Optional<Stock> stock = stockRepository.findById(stockDto.getStockId());
            if (stock.isPresent()) {
                stock.get().setStockName(stockDto.getStockName());
                stock.get().setStockSymbol(stockDto.getStockSymbol());
                stock.get().setCurrentPrice(stockDto.getCurrentPrice());
                stock.get().setChange(stockDto.getChange());
                stock.get().setBuyingPrice(stockDto.getBuyingPrice());
                stock.get().setSellingPrice(stockDto.getSellingPrice());
                stock.get().setHigh52(stockDto.getHigh52());
                stock.get().setLow52(stockDto.getLow52());
                stock.get().setMarketType(stockDto.getMarketType());
                stockRepository.saveAndFlush(stock.get());
            }
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

}
