package com.bmuschko.junit5.samples.injection;

import com.bmuschko.junit5.samples.ArithmeticOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReporterInjectionTest {

    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @Test
    void add(TestReporter testReporter) {
        String ciEnv = System.getenv("CI");
        boolean ci = ciEnv != null ? Boolean.parseBoolean(ciEnv) : false;
        testReporter.publishEntry("ci", Boolean.toString(ci));
        assertEquals(3, arithmeticOperation.add(1, 2));
    }
}
