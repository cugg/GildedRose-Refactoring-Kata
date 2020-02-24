package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypedItemFactoryTest {
    private Item agedBrie = new Item("Aged Brie", 2, 0);
    private Item any = new Item("Elixir of the Mongoose", 5, 7);
    private Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    private Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    private Item conjured = new Item("Conjured", 2, 0);
    @Test
    void creates_LegendaryItem_in_case_of_sulfuras() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(sulfuras);

        assertThat(typedItem).isInstanceOf(LegendaryItem.class);
    }

    @Test
    void creates_AgedItem_in_case_of_agedBrie() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(agedBrie);

        assertThat(typedItem).isInstanceOf(AgedItem.class);
    }

    @Test
    void creates_TypedItem_in_case_of_non_specific() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(any);

        assertThat(typedItem).isExactlyInstanceOf(TypedItem.class);
    }

    @Test
    void creates_TicketItem_in_case_of_backstage_pass() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(ticket);

        assertThat(typedItem).isInstanceOf(TicketItem.class);
    }

    @Test
    void creates_ConjuredItem_in_case_of_conjured() {
        TypedItem typedItem = TypedItemFactory.createTypedItem(conjured);

        assertThat(typedItem).isInstanceOf(ConjuredItem.class);
    }
}
