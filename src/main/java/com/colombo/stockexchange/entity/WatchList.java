package com.colombo.stockexchange.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Entity
@Data
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long watchListId;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "stock_id")
    @CollectionTable(name = "trade_stock")
    private Map<Integer, Integer> stockToAmount;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private User user;

    private String stocks;
}