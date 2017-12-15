package com.bmuschko.junit5.samples.extension.mockito;

import com.bmuschko.junit5.samples.DefaultFileManager;
import com.bmuschko.junit5.samples.FileManager;
import com.bmuschko.junit5.samples.FileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

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
    void canMockFileReadOperation(@Mock FileReader fileReader) throws IOException {
        FileManager fileManager = new DefaultFileManager(fileReader);
        String text = "hello";
        Files.write(testFile, text.getBytes());
        when(fileReader.readContent(testFile)).thenReturn(text);
        assertEquals(text, fileManager.readContent(testFile));
    }
}
