package com.gildedrose;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

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
        TypedItem typedItem = new LegendaryItem(item);
        typedItem.aging();

        assertThat(typedItem.getSellIn()).isEqualTo(INIT_SELL_IN);
    }

    @Test
    void update_does_not_affect_quality() {
        TypedItem typedItem = new LegendaryItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY);
    }

    @Test
    void expiration_does_not_affect_quality() {
        TypedItem typedItem = new LegendaryItem(item);
        typedItem.aging();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY);
    }
}
