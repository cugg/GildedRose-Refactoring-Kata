package com.gildedrose;

import static com.gildedrose.TypedItemFactory.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class ConjuredItemTest {
    private static final int INIT_SELL_IN = 10;
    private static final int INIT_QUALITY = 5;

    @Test
    void updates_decrease_quality_by_2_when_default_typed_item_conjured() {
        Item item = new Item("Conjured Any Item", INIT_SELL_IN, INIT_QUALITY);
        TypedItem typedItem = createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 2);
    }

    @Test
    void updates_decrease_quality_by_4_when_default_typed_item_double_conjured() {
        Item item = new Item("Conjured conjured Any Item", INIT_SELL_IN, INIT_QUALITY);
        TypedItem typedItem = createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 4);
    }

    @Test
    void updates_increase_quality_by_1_when_aged_brie_conjured() {
        Item item = new Item("Conjured Aged Brie", INIT_SELL_IN, INIT_QUALITY);
        TypedItem typedItem = createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 1);
    }

    @Test
    void aging_further_than_expiration_decrease_quality_by_2_when_default_typed_item_conjured() {
        Item expiredItem = new Item("Conjured Any Item", 0, INIT_QUALITY);
        TypedItem typedItem = createTypedItem(expiredItem);
        typedItem.aging();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 2);
    }

}
