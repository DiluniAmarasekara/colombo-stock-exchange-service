package com.colombo.stockexchange.repository;

import com.colombo.stockexchange.dto.TradeDto;
import com.colombo.stockexchange.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Diluni
 * on 12/31/2022
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findAllByBuySell(String buySell);
    @Query("SELECT DISTINCT new com.colombo.stockexchange.dto.TradeDto(c.stock.stockId, c.tradeId, c.individualPrice, c.quantity) FROM Trade c WHERE c.stock.stockId=:stockId")
    List<TradeDto> findAllByStock_StockId(Long stockId);
}
