package com.colombo.stockexchange.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Temporal(TemporalType.DATE)
    private Date timeStampDate;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Transaction() {
    }

    public Transaction(Date timeStampDate, Double totalPrice, User user) {
        this.timeStampDate = timeStampDate;
        this.totalPrice = totalPrice;
        this.user = user;
    }
}
