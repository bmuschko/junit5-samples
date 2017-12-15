package com.bmuschko.junit5.samples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionTest {

    private final static String SYS_PROP_KEY = "junit5.test";
    private final static String SYS_PROP_TRUE_VALUE = "true";
    private final static String SYS_PROP_FALSE_VALUE = "false";
    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @Test
    void testOnlyOnSystemSystemPropertySet() {
        System.setProperty(SYS_PROP_KEY, SYS_PROP_TRUE_VALUE);
        assumeTrue(SYS_PROP_TRUE_VALUE.equals(System.getProperty(SYS_PROP_KEY)));
        assertEquals(3, arithmeticOperation.add(1, 2));
        System.clearProperty(SYS_PROP_KEY);
    }

    @Test
    void skipsOnSystemSystemPropertyNotSet() {
        System.setProperty(SYS_PROP_KEY, SYS_PROP_FALSE_VALUE);
        assumeTrue(SYS_PROP_TRUE_VALUE.equals(System.getProperty(SYS_PROP_KEY)));
        assertEquals(3, arithmeticOperation.add(1, 2));
        System.clearProperty(SYS_PROP_KEY);
    }
}
