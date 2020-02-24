package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketItemTest {
    public static final int INIT_QUALITY = 40;

    @Test
    void updates_increase_quality_by_1_when_sellIn_is_higher_than_10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, INIT_QUALITY);
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 1);
    }

    @Test
    void updates_increase_quality_by_2_when_sellIn_is_higher_than_5_and_lower_than_11() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, INIT_QUALITY);
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 2);
    }

    @Test
    void updates_increase_quality_by_3_when_sellIn_is_lower_than_6() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, INIT_QUALITY);
        TypedItem typedItem = TypedItemFactory.createTypedItem(item);
        typedItem.updateQuality();

        assertThat(typedItem.getQuality()).isEqualTo(INIT_QUALITY + 3);
    }
}
