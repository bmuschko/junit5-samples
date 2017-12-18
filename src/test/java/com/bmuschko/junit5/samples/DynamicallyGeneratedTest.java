package com.bmuschko.junit5.samples;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicallyGeneratedTest {

    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);

        return Arrays.asList(
                dynamicTest(String.format("add %s to %s", a, b), () -> assertTrue(arithmeticOperation.add(a, b) >= 0)),
                dynamicTest(String.format("multiply %s with %s", a, b), () -> assertTrue(arithmeticOperation.multiply(a, b) >= 0))
        );
    }
}
