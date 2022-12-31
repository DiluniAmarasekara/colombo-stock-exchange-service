package com.colombo.stockexchange.service.impl;

import com.colombo.stockexchange.dto.TradeDto;
import com.colombo.stockexchange.entity.Trade;
import com.colombo.stockexchange.repository.TradeRepository;
import com.colombo.stockexchange.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by Diluni
 * on 12/31/2022
 */
@Service
public class TradeServiceImpl implements TradeService {
    Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);

    @Autowired
    private TradeRepository tradeRepository;

    @Transactional
    @Override
    public Boolean buy(TradeDto tradeDto) {
        Optional<Trade> trade = tradeRepository.findById(tradeDto.getTradeId());
        if (trade.isPresent()) {
            if (trade.get().getBuySell().equals("SELL") && tradeDto.getQuantity() <= trade.get().getQuantity()) {
//                TODO transactions set up
                Trade buyStock = new Trade(tradeDto.getTradeId(), trade.get().getStock(),
                        tradeDto.getIndividualPrice(), tradeDto.getQuantity(), "BUY", null);
                trade.get().setQuantity(trade.get().getQuantity() - tradeDto.getQuantity());
                try {
                    tradeRepository.saveAndFlush(buyStock);
                    tradeRepository.saveAndFlush(trade.get());
                    return true;
                } catch (RuntimeException e) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public List<Trade> getAllSell() {
        return tradeRepository.findAllByBuySell("SELL");
    }
}
