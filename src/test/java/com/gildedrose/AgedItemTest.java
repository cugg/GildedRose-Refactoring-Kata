package com.gildedrose;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class AgedItemTest {
    private static final int INIT_SELL_IN = 10;
    private static final int INIT_QUALITY = 40;
    private Item item;

    @BeforeEach
    void init() {
        item = new Item("Aged Brie", INIT_SELL_IN, INIT_QUALITY);
    }

    @Test
    void updates_increase_quality_by_1() {
        TypedItem typedItem = new AgedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 1);
    }

    @Test
    void quality_continues_to_increase_after_expiration() {
        Item expiredItem = new Item("Aged Brie", 0, INIT_QUALITY);
        TypedItem typedItem = new AgedItem(expiredItem);
        typedItem.aging();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 1);
    }
}
