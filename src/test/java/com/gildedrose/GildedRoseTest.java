package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {
    private Item[] itemsOfAllTypes= GildedRoseFactory.createGoldenMasterItems();

    @Test
    void never_increases_quality_over_50() {
        for (Item item : itemsOfAllTypes) {
            item.quality = 50;
            GildedRose.increaseQuality(new TypedItem(item));
            assertThat(item.quality).isLessThanOrEqualTo(50);
        }
    }
    @Test
    void never_decreases_quality_under_0() {
        for (Item item : itemsOfAllTypes) {
            item.quality = 0;
            GildedRose.decreaseQuality(new TypedItem(item));
            assertThat(item.quality).isGreaterThanOrEqualTo(0);
        }
    }

}
