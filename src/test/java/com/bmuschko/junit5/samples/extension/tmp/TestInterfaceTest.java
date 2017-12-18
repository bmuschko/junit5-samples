package com.bmuschko.junit5.samples.extension.tmp;

import com.bmuschko.junit5.samples.DefaultFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInterfaceTest implements TemporaryFolderPrerequisite {

    private static final String TEXT = "hello";
    private final DefaultFileReader fileReader = new DefaultFileReader();
    private File testFile;

    @BeforeEach
    void setup(@TemporaryFolder File temporaryFolder) throws IOException {
        testFile = new File(temporaryFolder, "hello.txt");
        testFile.createNewFile();
    }

    @Test
    void canReadFile() throws IOException {
        Files.write(testFile.toPath(), TEXT.getBytes());
        assertEquals(TEXT, fileReader.readContent(testFile.toPath()));
    }
}
