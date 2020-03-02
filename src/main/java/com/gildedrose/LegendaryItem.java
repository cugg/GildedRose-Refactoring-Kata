package com.gildedrose;

class LegendaryItem extends TypedItem{

    LegendaryItem(Item item) {
        super(item);
    }

    LegendaryItem(Item item, int conjuredFactor) {
        super(item, conjuredFactor);
    }

    @Override
    void aging() {
    }

    @Override
    void updateQuality() {
    }
}
