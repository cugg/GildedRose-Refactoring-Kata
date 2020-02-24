package com.gildedrose;

class AgedItem extends TypedItem{

    AgedItem(Item item) {
        super(item, ItemType.AGED);
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
