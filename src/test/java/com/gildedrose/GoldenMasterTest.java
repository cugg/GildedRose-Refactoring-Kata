package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class GoldenMasterTest {

    @Test
    void safetynet() throws IOException {
        Path path = Paths.get("newrun.txt");
        Path expectedFilePath = Paths.get("src/test/resources/goldenmaster30days.txt");

        TexttestFixture.run(30, path);
        assertThat(path).hasSameTextualContentAs(expectedFilePath);
    }

}
