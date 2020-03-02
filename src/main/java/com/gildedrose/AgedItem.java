package com.gildedrose;

class AgedItem extends TypedItem{

    AgedItem(Item item) {
        super(item);
    }

    AgedItem(Item item, int conjuredFactor) {
        super(item, conjuredFactor);
    }

    @Override
    void updateQuality() {
        increaseQuality();
    }

    @Override
    void updateQualityWhenExpired() {
        increaseQuality();
    }
}
