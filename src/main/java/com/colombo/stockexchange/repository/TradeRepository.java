package com.colombo.stockexchange.repository;

import com.colombo.stockexchange.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Diluni
 * on 12/31/2022
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findAllByBuySell(String buySell);

    List<Trade> findAllByStock_StockId(Long stockId);
}
