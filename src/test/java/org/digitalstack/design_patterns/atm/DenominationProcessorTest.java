package org.digitalstack.design_patterns.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DenominationProcessorTest {

    DenominationProcessor processor;
    DenominationProcessor mockProcessor = mock(DenominationProcessor.class);

    @BeforeEach
    public void setUp() {
        processor = new DenominationProcessor(Denomination.ONE_HUNDRED);
        processor.setNextProcessor(mockProcessor);
    }

    @Test
    public void processingStopsForExactAmount() {
        //given
        int amount = 500;

        //when
        Optional<Map<Denomination, Integer>> result = processor.handle(amount, new HashMap<>());

        //then
        assertTrue(result.isPresent());
        assertEquals(5, result.get().get(Denomination.ONE_HUNDRED));
    }

    @Test
    public void whenStockIsDepletedPassRemainderToTheNextProcessor() {
        //given
        int amount = 1200;
        Map<Denomination, Integer> expectedPartialResult = new HashMap<>();
        expectedPartialResult.put(Denomination.ONE_HUNDRED, 10);

        //when
        processor.handle(amount, new HashMap<>());

        //then
        assertEquals(0, processor.stock);
        verify(mockProcessor).handle(200, expectedPartialResult);
    }

    @Test
    public void whenStockIsDepletedAndNoNextProcessorReturnEmpty() {
        //given
        int amount = 1200;
        processor.setNextProcessor(null);

        //when
        Optional<Map<Denomination, Integer>> result = processor.handle(amount, new HashMap<>());

        //then
        assertTrue(result.isEmpty());
    }


}