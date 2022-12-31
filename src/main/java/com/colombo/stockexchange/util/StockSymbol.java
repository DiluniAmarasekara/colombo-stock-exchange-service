package com.colombo.stockexchange.util;

/**
 * created by Diluni
 * on 12/19/2022
 */
public enum StockSymbol {
    A("Class A shares"),
    B("Class B shares"),
    C("Mutual Funds"),
    D("Rights"),
    E("Voting share"),
    F("Foreign issue"),
    G("In bankruptcy proceedings"),
    H("Warrants");

    String value;

    StockSymbol(String value) {
        this.value = value;
    }
}
