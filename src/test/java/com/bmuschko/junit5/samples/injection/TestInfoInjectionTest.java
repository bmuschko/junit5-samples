package com.bmuschko.junit5.samples.injection;

import com.bmuschko.junit5.samples.ArithmeticOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInfoInjectionTest {

    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @DisplayName("Addition")
    @Tag("fast")
    @Tag("basic")
    @Test
    void add(TestInfo testInfo) {
        assertEquals("Addition", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("fast"));
        assertTrue(testInfo.getTags().contains("basic"));
        assertEquals(3, arithmeticOperation.add(1, 2));
    }
}
