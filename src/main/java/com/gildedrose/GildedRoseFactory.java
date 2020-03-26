package com.gildedrose;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

class GildedRoseFactory {

    static Item[] createItems(Path inputFile) throws IOException {

        List<Item> items;

        try (BufferedReader reader = Files.newBufferedReader(inputFile, StandardCharsets.UTF_8)) {
            items = reader.lines().map(GildedRoseFactory::createItem).collect(Collectors.toList());
        }
        return items.toArray(new Item[0]);
    }

    private static Item createItem(String line) {
        int quality = Integer.parseInt(line.substring(line.lastIndexOf(", ")+2));
        String lineWithoutQuality = line.substring(0, line.lastIndexOf(", "));
        int sellIn = Integer.parseInt(lineWithoutQuality.substring(lineWithoutQuality.lastIndexOf(", ")+2));
        String name = lineWithoutQuality.substring(0, lineWithoutQuality.lastIndexOf(", "));
        return new Item(name, sellIn, quality);
    }
}
