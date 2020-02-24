package com.gildedrose;

class TicketItem extends TypedItem {

    TicketItem(Item item) {
        super(item, ItemType.TICKET);
    }

    @Override
    void updateQuality() {
        increaseQuality();

        if (getSellIn() < 11) {
            increaseQuality();
        }

        if (getSellIn() < 6) {
            increaseQuality();
        }
    }
}
