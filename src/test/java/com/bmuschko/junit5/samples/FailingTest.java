package com.bmuschko.junit5.samples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class FailingTest {

    @Test
    void fails() {
        fail("a failing test");
    }
}
