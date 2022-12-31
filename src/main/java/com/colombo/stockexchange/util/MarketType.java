package com.colombo.stockexchange.util;

/**
 * created by Diluni
 * on 12/19/2022
 */
public enum MarketType {
    CS("Common stock"),
    PS("Preferred stock"),
    LS("Large-cap stocks"),
    MS("Mid-cap stocks"),
    SS("Small-cap stocks"),
    DS("Domestic stock"),
    IS("International stocks"),
    GS("Growth stocks");

    String value;

    MarketType(String value) {
        this.value = value;
    }
}
