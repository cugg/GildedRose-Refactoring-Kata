package com.gildedrose;

class ConjuredItem extends TypedItem {
    ConjuredItem(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decreaseQuality();
        decreaseQuality();
    }

    @Override
    void updateQualityWhenExpired() {
        decreaseQuality();
        decreaseQuality();
    }
}
