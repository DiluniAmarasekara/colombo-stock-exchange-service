package com.colombo.stockexchange.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * created by Diluni
 * on 12/19/2022
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private boolean verified;

    private String phoneNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserBankDetails userBankDetails;
}
