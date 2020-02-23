package com.gildedrose;

import static com.gildedrose.ItemType.*;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            TypedItem typedItem = new TypedItem(item);
            updateItem(typedItem);
        }
    }

    private void updateItem(TypedItem item) {
        updateQuality(item);
        updateSellIn(item);
        if (item.item.sellIn < 0) {
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

    private void updateSellIn(TypedItem item) {
        if (!item.type.equals(LEGENDARY)) {
            item.item.sellIn = item.item.sellIn - 1;
        }
    }

    private void updateQuality(TypedItem item) {
        if (item.type.equals(AGED)) {
            item.increaseQuality();
        } else if (item.type.equals(TICKET)) {
            updateBackstagePassQuality(item);
        } else {
            if (!item.type.equals(LEGENDARY)) {
                item.decreaseQuality();
            }
        }
    }

    private void updateBackstagePassQuality(TypedItem item) {
        item.increaseQuality();

        if (item.item.sellIn < 11) {
            item.increaseQuality();
        }

        if (item.item.sellIn < 6) {
            item.increaseQuality();
        }

    }
}