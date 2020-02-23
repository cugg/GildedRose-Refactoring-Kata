package com.gildedrose;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

class TexttestFixture {

    static void run(int days, Path tempFile) throws IOException {
        days+=1;//day 0

        Item[] items = GildedRoseFactory.createGoldenMasterItems();
        GildedRose app = new GildedRose(items);

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.append("OMGHAI!");

            for (int i = 0; i < days; i++) {

                writer.newLine();
                writer.append(("-------- day " + i + " --------"));

                writer.newLine();
                writer.append(("name, sellIn, quality"));
                for (Item item : items) {
                    writer.newLine();
                    writer.append(item.toString());
                }
                writer.newLine();

                app.updateQuality();
            }
        }
    }
}
