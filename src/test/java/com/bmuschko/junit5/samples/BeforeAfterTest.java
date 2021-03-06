package com.bmuschko.junit5.samples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeAfterTest {

    private final DefaultFileReader fileReader = new DefaultFileReader();
    private Path testFile;

    @BeforeEach
    void setup() throws IOException {
        testFile = Files.createTempFile("junit5", ".tmp");
    }

    @AfterEach
    void cleanup() {
        testFile.toFile().delete();
    }

    @Test
    void canReadFile() throws IOException {
        String text = "hello";
        Files.write(testFile, text.getBytes());
        assertEquals(text, fileReader.readContent(testFile));
    }
}
