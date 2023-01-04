package com.colombo.stockexchange.controller;

import com.colombo.stockexchange.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * created by Diluni
 * on 1/4/2023
 */
@RestController
@RequestMapping("transaction")
public class TransactionController {
    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestParam Long userId, @RequestParam Double amount) {
        logger.info("Enter the transaction add POST REST API");
        Boolean status = transactionService.add(userId, amount);
        return status ? new ResponseEntity<>("Transaction has been added successfully!", HttpStatus.CREATED) : new ResponseEntity<>("Transaction creation has been failed!", HttpStatus.EXPECTATION_FAILED);
    }
}
