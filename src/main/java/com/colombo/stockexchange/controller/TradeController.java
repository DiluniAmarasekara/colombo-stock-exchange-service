package com.colombo.stockexchange.controller;

import com.colombo.stockexchange.dto.TradeDto;
import com.colombo.stockexchange.entity.Trade;
import com.colombo.stockexchange.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by Diluni
 * on 12/30/2022
 */
@RestController
@RequestMapping("trade")
public class TradeController {
    Logger logger = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    private TradeService tradeService;

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ResponseEntity<String> buy(@RequestBody TradeDto tradeDto) {
        logger.info("Enter the stock buy POST REST API");
        Boolean status = tradeService.buy(tradeDto);
        return status ? new ResponseEntity<>("Stock buy has been successfully!", HttpStatus.OK) : new ResponseEntity<>("Stock buy has been failed!", HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(value = "/getAllSell", method = RequestMethod.GET)
    public List<Trade> getAllSell() {
        logger.info("Enter the trade get GET REST API");
        return tradeService.getAllSell();
    }

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public ResponseEntity<String> sell(@RequestBody TradeDto tradeDto) {
        logger.info("Enter the stock sell POST REST API");
        Boolean status = tradeService.sell(tradeDto);
        return status ? new ResponseEntity<>("Stock sell creation has been successfully!", HttpStatus.OK) : new ResponseEntity<>("Stock sell creation has been failed!", HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(value = "/getAllTradesByStock", method = RequestMethod.GET)
    public List<TradeDto> getAllTradesByStock(@RequestParam Long stockId) {
        logger.info("Enter the getAllTradesByStock GET REST API");
        return tradeService.getAllTradesByStock(stockId);
    }

}
