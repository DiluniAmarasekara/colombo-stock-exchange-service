package com.colombo.stockexchange.repository;

import com.colombo.stockexchange.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Diluni
 * on 1/4/2023
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
