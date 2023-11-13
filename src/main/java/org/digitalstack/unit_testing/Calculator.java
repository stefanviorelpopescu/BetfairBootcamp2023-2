package org.digitalstack.unit_testing;

import java.util.Optional;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // 2 + 3
        String input = s.nextLine();
        String[] split = input.split(" ");

        Calculator calculator = new Calculator();
        Optional<Operator> optionalOperator = Operator.getBySymbol(split[1]);
        if (optionalOperator.isPresent()) {
            Operator operator = optionalOperator.get();
            switch (operator) {

                case PLUS -> {
                    System.out.println("Sum is : " + calculator.add(Integer.parseInt(split[0]), Integer.parseInt(split[2])));
                }
                case MINUS -> {
                }
                case MULTIPLY -> {
                }
                case DIVIDE -> {
                }
            }
        }


    }

    public int add(int first, int second) {
        return first + second;
    }

}
