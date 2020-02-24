package com.gildedrose;

import static com.gildedrose.ItemType.*;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            TypedItem typedItem = TypedItemFactory.createTypedItem(item);
            updateItem(typedItem);
        }
    }

    private void updateItem(TypedItem item) {
        item.updateQuality();
        item.aging();
        if (item.getSellIn() < 0) {
            updateQualityWhenExpired(item);
        }
    }

    private void updateQualityWhenExpired(TypedItem item) {
        if (item.type.equals(AGED)) {
            item.increaseQuality();
        } else if (item.type.equals(TICKET)) {
            item.decreaseQualityToMinimum();
        } else if (item.type.equals(LEGENDARY)) {
            return;
        } else {
            item.decreaseQuality();
        }
    }
}