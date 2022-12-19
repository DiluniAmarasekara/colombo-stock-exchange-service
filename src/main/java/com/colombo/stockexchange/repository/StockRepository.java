package com.colombo.stockexchange.repository;

import com.colombo.stockexchange.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
