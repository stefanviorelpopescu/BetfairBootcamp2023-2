package org.digitalstack.design_patterns.atm;

import java.util.Map;
import java.util.Optional;

public class DenominationProcessor {

    DenominationProcessor nextProcessor;
    Denomination denomination;
    int stock = 10;

    public Optional<Map<Denomination, Integer>> handle(int sumOfMoney, Map<Denomination, Integer> partialResult) {

        int value = denomination.getValue();
        int count = sumOfMoney / value;
        int remainingSum = sumOfMoney % value;

        if (stock >= count) {
            stock -= count;
        } else {
            count = stock;
            stock = 0;
            remainingSum = sumOfMoney - (count * value);
        }

        if (count > 0) {
            partialResult.put(denomination, count);
        }

        if (remainingSum == 0) {
            return Optional.of(partialResult);
        } else {
            if (nextProcessor != null) {
                return nextProcessor.handle(remainingSum, partialResult);
            } else {
                return Optional.empty();
            }
        }
    }

    public DenominationProcessor(Denomination denomination) {
        this.denomination = denomination;
    }

    public DenominationProcessor setNextProcessor(DenominationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
        return nextProcessor;
    }
}
