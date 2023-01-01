package com.colombo.stockexchange.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Entity
@Data
public class Trade extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    private Double individualPrice;

    private Integer quantity;

    private String buySell;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public Trade(){}

    public Trade(Stock stock, Double individualPrice, Integer quantity, String buySell, Transaction transaction) {
        this.stock = stock;
        this.individualPrice = individualPrice;
        this.quantity = quantity;
        this.buySell = buySell;
        this.transaction = transaction;
    }

    public Trade(Double individualPrice, Integer quantity, Transaction transaction) {
        this.individualPrice = individualPrice;
        this.quantity = quantity;
        this.transaction = transaction;
    }

}
