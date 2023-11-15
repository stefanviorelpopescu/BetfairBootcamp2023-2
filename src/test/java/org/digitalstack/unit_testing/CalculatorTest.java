package org.digitalstack.unit_testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    static Calculator calculator;

    @BeforeAll
    public static void setup() {
        calculator = new Calculator();
    }

    @Test
    public void forTwoPositiveNumbers_returnSum() {
        //given
        int first = 4;
        int second = 42;
        int expectedResult = first + second;

        //when
        int actualResult = calculator.add(first, second);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void forTwoOppositeNumbers_returnZero() {
        //given
        int first = 4;
        int second = -4;

        //when
        int result = calculator.add(first, second);

        //then
        assertEquals(0, result);
    }

    @Test
    public void forOneNumberAndZero_returnFirstNumber() {
        //given
        int first = 4;
        int second = 0;

        //when
        int result = calculator.add(first, second);

        //then
        assertEquals(first, result);
    }

    @ParameterizedTest
    @CsvSource({"42,4,46", "4,-4,0", "4,0,4"})
    public void multipleAddScenarios(Integer first, Integer second, Integer expected) {
        //given

        //when
        int result = calculator.add(first, second);

        //then
        assertEquals(expected, result);
    }

    @Test
    public void forNullOperand_ThrowException() {
        //given
        int first = 4;

        //when
        assertThrows(NullPointerException.class, () -> calculator.add(first, null));

        //then
    }

}