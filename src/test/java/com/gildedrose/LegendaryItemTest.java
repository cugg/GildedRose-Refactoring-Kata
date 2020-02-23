package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryItemTest {
    public static final int INIT_SELL_IN = 0;
    Item item;

    @BeforeEach
    void init(){
        item = new Item("Sulfuras, Hand of Ragnaros", INIT_SELL_IN, 80);
    }

    @Test
    void updateSellIn_does_not_affect_sell_in() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateSellIn();
        assertThat(typedItem.getSellIn()).isEqualTo(INIT_SELL_IN);
    }
}
