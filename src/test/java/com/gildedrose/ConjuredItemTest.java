package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredItemTest {
    private static final int INIT_SELL_IN = 10;
    private static final int INIT_QUALITY = 5;

    @Test
    void updates_decrease_quality_by_2() {
        Item item = new Item("Conjured", INIT_SELL_IN, INIT_QUALITY);
        TypedItem typedItem = new ConjuredItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 2);
    }

    @Test
    void aging_further_than_expiration_decrease_quality_by_2() {
        Item expiredItem = new Item("Conjured", 0, INIT_QUALITY);
        TypedItem typedItem = new ConjuredItem(expiredItem);
        typedItem.aging();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY - 2);
    }

}
