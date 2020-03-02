package com.gildedrose;

class TicketItem extends TypedItem {

    TicketItem(Item item) {
        super(item);
    }

    TicketItem(Item item, int conjuredFactor) {
        super(item, conjuredFactor);
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

    @Override
    void updateQualityWhenExpired() {
        decreaseQualityToMinimum();
    }
}
