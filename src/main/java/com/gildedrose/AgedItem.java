package com.gildedrose;

class AgedItem extends TypedItem{

    AgedItem(Item item) {
        super(item);
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
