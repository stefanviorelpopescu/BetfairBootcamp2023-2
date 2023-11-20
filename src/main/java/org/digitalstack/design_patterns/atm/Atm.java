package org.digitalstack.design_patterns.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Atm {

    DenominationProcessor moneyHandler = new DenominationProcessor(Denomination.FIVE_HUNDRED);;

    public Atm() {
        moneyHandler.setNextProcessor(new DenominationProcessor(Denomination.TWO_HUNDRED))
                .setNextProcessor(new DenominationProcessor(Denomination.ONE_HUNDRED))
                .setNextProcessor(new DenominationProcessor(Denomination.FIFTY))
                .setNextProcessor(new DenominationProcessor(Denomination.TEN));
    }

    public void withdraw(int sumOfMoney) {
        System.out.println("Withdrawing: " + sumOfMoney);
        Optional<Map<Denomination, Integer>> result = moneyHandler.handle(sumOfMoney, new HashMap<>());
        if (result.isEmpty()) {
            System.out.println("Not enough money");
        } else {
            System.out.println(result);
        }
    }

}
