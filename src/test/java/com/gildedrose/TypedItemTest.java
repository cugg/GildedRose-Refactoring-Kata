package com.gildedrose;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TypedItemTest {

    private static final int INIT_SELL_IN = 10;
    private static final int INIT_QUALITY = 5;

    @Test
    void never_increases_quality_over_50() {
        Item item = new Item("Any", INIT_SELL_IN, 50);
        TypedItem typedItem = new TypedItem(item);
        typedItem.increaseQuality();

        assertThat(typedItem.getQuality()).isLessThanOrEqualTo(50);
    }

    @Test
    void never_decreases_quality_under_0() {
        Item item = new Item("Any", INIT_SELL_IN, 0);
        TypedItem typedItem = new TypedItem(item);
        typedItem.decreaseQuality();

        assertThat(typedItem.getQuality()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void aging_decrease_sellIn_by_1() {
        Item item = new Item("Any", INIT_SELL_IN, INIT_QUALITY);
        TypedItem typedItem = new TypedItem(item);
        typedItem.aging();

        assertThat(typedItem.getSellIn()).isEqualTo(INIT_SELL_IN - 1);
    }

    @Test
    void updates_decrease_quality_by_1() {
        Item item = new Item("Any", INIT_SELL_IN, INIT_QUALITY);
        TypedItem typedItem = new TypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 1);
    }

    @Test
    void aging_further_than_expiration_decrease_quality_by_1() {
        Item expiredItem = new Item("Any", 0, INIT_QUALITY);
        TypedItem typedItem = new TypedItem(expiredItem);
        typedItem.aging();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 1);
    }

}
