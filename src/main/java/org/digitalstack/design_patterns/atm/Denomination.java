package org.digitalstack.design_patterns.atm;

import lombok.Getter;

@Getter
public enum Denomination {
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ;

    private final int value;

    Denomination(int value) {
        this.value = value;
    }
}
