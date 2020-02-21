package com.gildedrose;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class TexttestFixture {

    public static void run(int days, Path tempFile) throws IOException {
        days+=1;//day 0

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile, Charset.forName("UTF-8"))) {
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
