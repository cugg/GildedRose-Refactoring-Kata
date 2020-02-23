package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypedItemTest {

    private static final int INIT_SELL_IN = 10;

    @Test
    void never_increases_quality_over_50() {
        Item item = new Item("Any", INIT_SELL_IN, 50);
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.increaseQuality();
        assertThat(typedItem.getQuality()).isLessThanOrEqualTo(50);
    }

    @Test
    void never_decreases_quality_under_0() {
        Item item = new Item("Any", INIT_SELL_IN, 0);
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.decreaseQuality();
        assertThat(typedItem.getQuality()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void updateSellIn_decrease_sellIn_by_1() {
        Item item = new Item("Any", INIT_SELL_IN, 0);
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateSellIn();
        assertThat(typedItem.getSellIn()).isEqualTo(INIT_SELL_IN-1);
    }
}
