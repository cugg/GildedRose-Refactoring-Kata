package com.gildedrose;

import static org.assertj.core.api.Assertions.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;

import org.junit.jupiter.api.*;

class GoldenMasterTest {

    @Test
    void safetynet() throws IOException {

        Path logFilePath = Paths.get("newrun.txt");
        cleanPreviousLogFile(logFilePath);
        Path expectedFilePath = Paths.get("src/test/resources/goldenmaster30days.txt");

        Main.main(new String[]{"src/test/resources/goldenmasteritems.txt", "30"});

        assertThat(logFilePath).hasSameTextualContentAs(expectedFilePath);
    }

    private void cleanPreviousLogFile(Path logFilePath) throws IOException {
        if (Files.exists(logFilePath)) {
            Files.move(logFilePath, Paths.get("oldrun-" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + ".txt"));
        }
    }

}
