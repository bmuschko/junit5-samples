package com.bmuschko.junit5.samples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartiallyDisabledTest {

    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @Test
    void canAdd() {
        assertEquals(3, arithmeticOperation.add(1, 2));
    }

    @Test
    void canSubstract() {
        assertEquals(1, arithmeticOperation.substract(2, 1));
    }

    @Test
    @Disabled("for demonstration purposes")
    void canMultiply() {
        assertEquals(6, arithmeticOperation.multiply(2, 3));
    }

    @Test
    void canDivide() {
        assertEquals(3, arithmeticOperation.divide(6, 2));
    }
}
