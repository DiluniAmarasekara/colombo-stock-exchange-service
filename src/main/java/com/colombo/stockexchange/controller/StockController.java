package com.colombo.stockexchange.controller;

import com.colombo.stockexchange.entity.Stock;
import com.colombo.stockexchange.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * created by Diluni
 * on 12/19/2022
 */
@RestController
@RequestMapping("stock")
public class StockController {
    Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@Valid @RequestBody(required = true) Stock stock) {
        logger.info("Enter the stock add POST REST API");
        Boolean status = stockService.add(stock);
        return status ? new ResponseEntity<>("Stock has been added successfully!", HttpStatus.CREATED) : new ResponseEntity<>("Stock creation has been failed!", HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@Valid @RequestBody(required = true) Stock stock) {
        logger.info("Enter the stock update PUT REST API");
        Boolean status = stockService.update(stock);
        return status ? new ResponseEntity<>("Stock has been updated successfully!", HttpStatus.CREATED) : new ResponseEntity<>("Stock update has been failed!", HttpStatus.EXPECTATION_FAILED);
    }

}
