package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryItemTest {
    private static final int INIT_SELL_IN = 0;
    private static final int INIT_QUALITY = 80;
    private Item item;

    @BeforeEach
    void init(){
        item = new Item("Sulfuras, Hand of Ragnaros", INIT_SELL_IN, INIT_QUALITY);
    }

    @Test
    void aging_does_not_affect_sell_in() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.aging();

        assertThat(typedItem.getSellIn()).isEqualTo(INIT_SELL_IN);
    }

    @Test
    void update_does_not_affect_quality() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY);
    }

    @Test
    void expiration_does_not_affect_quality() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.aging();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY);
    }
}
