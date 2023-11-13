package org.digitalstack.unit_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void forTwoPositiveNumbers_returnSum() {
        //given
        int first = 4;
        int second = 42;

        //when
        int result = calculator.add(first, second);

        //then
        Assertions.assertEquals(first+second, result);
    }

}