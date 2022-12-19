package com.colombo.stockexchange.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Entity
@Data
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    @OneToOne(optional = true, fetch = FetchType.EAGER)
    private Stock stock;

    private Double individualPrice;

    private Integer quantity;

    private String buySell;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;
}
