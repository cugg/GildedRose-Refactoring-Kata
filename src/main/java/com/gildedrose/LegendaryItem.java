package com.gildedrose;

class LegendaryItem extends TypedItem{

    LegendaryItem(Item item) {
        super(item, ItemType.LEGENDARY);
    }

    @Override
    void aging() {
    }

    @Override
    void updateQuality() {
    }
}
