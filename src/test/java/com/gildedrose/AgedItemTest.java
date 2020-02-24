package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedItemTest {
    private static final int INIT_SELL_IN = 10;
    public static final int INIT_QUALITY = 40;
    private Item item;

    @BeforeEach
    void init(){
        item = new Item("Aged Brie", INIT_SELL_IN, INIT_QUALITY);
    }

    @Test
    void updates_increase_quality_by_1() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 1);
    }
}
