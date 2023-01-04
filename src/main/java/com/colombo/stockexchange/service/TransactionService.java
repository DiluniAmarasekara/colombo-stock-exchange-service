package com.colombo.stockexchange.service;

/**
 * created by Diluni
 * on 1/4/2023
 */
public interface TransactionService {
    Boolean add(Long userId, Double amount);
}
