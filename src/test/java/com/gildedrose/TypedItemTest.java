package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TypedItemTest {

    @Test
    void never_increases_quality_over_50() {
        Item item = new Item("Any", 10, 50);
        TypedItem typedItem = new TypedItem(item);
        typedItem.increaseQuality();
        assertThat(typedItem.getQuality()).isLessThanOrEqualTo(50);

    }

    @Test
    void never_decreases_quality_under_0() {
        Item item = new Item("Any", 10, 0);
        TypedItem typedItem = new TypedItem(item);
        typedItem.increaseQuality();
        assertThat(typedItem.getQuality()).isGreaterThanOrEqualTo(0);
    }
}
