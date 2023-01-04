package com.colombo.stockexchange.service.impl;

import com.colombo.stockexchange.entity.Transaction;
import com.colombo.stockexchange.entity.User;
import com.colombo.stockexchange.repository.TransactionRepository;
import com.colombo.stockexchange.repository.UserRepository;
import com.colombo.stockexchange.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * created by Diluni
 * on 1/4/2023
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public Boolean add(Long userId, Double amount) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Transaction transaction = new Transaction(new Date(), amount, user.get());
            transactionRepository.save(transaction);
            return true;
        }
        return false;
    }
}
