package org.digitalstack.unit_testing;

import java.util.Optional;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Optional<Operator> getBySymbol(String symbol) {
        for (Operator value : Operator.values()) {
            if (value.getSymbol().equals(symbol)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }

}
