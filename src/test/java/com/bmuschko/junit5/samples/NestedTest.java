package com.bmuschko.junit5.samples;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedTest {

    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @Nested
    class MoreOrLess {

        @Test
        void canAdd() {
            assertEquals(3, arithmeticOperation.add(1, 2));
        }

        @Test
        void canSubstract() {
            assertEquals(1, arithmeticOperation.substract(2, 1));
        }
    }

    @Nested
    class MultiplyOrDivide {

        @Test
        void canMultiply() {
            assertEquals(6, arithmeticOperation.multiply(2, 3));
        }

        @Test
        void canDivide() {
            assertEquals(3, arithmeticOperation.divide(6, 2));
        }
    }
}
