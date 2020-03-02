package com.gildedrose;

import java.io.*;
import java.nio.file.*;

import org.apache.logging.log4j.*;

public class Main {
    private static Logger logger = LogManager.getLogger("GildedRose");

    public static void main(String[] args) throws IOException {
        int days = Integer.parseInt(args[1]) + 1;//day 0

        Item[] items = GildedRoseFactory.createItems(Paths.get(args[0]));
        GildedRose app = new GildedRose(items);

        logger.info("OMGHAI!");

        for (int i = 0; i < days; i++) {

            logger.info(("-------- day " + i + " --------"));

            logger.info(("name, sellIn, quality"));
            for (Item item : items) {
                logger.info(item.toString());
            }
            if(i < days-1) {
                logger.info("");
            }
            app.updateQuality();
        }
    }
}
