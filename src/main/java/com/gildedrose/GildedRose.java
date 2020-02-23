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
            increaseQuality(item);
        } else if (item.type.equals(TICKET)) {
            item.item.quality = 0;
        } else if (item.type.equals(LEGENDARY)) {
            return;
        } else {
            decreaseQuality(item);
        }
    }

    private void updateSellIn(TypedItem item) {
        if (!item.type.equals(LEGENDARY)) {
            item.item.sellIn = item.item.sellIn - 1;
        }
    }

    private void updateQuality(TypedItem item) {
        if (item.type.equals(AGED)) {
            increaseQuality(item);
        } else if (item.type.equals(TICKET)) {
            updateBackstagePassQuality(item);
        } else {
            if (!item.type.equals(LEGENDARY)) {
                decreaseQuality(item);
            }
        }
    }

    private void updateBackstagePassQuality(TypedItem item) {
        increaseQuality(item);

        if (item.item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.item.sellIn < 6) {
            increaseQuality(item);
        }

    }

    static void increaseQuality(TypedItem item) {
        if (item.item.quality < 50) {
            item.item.quality = item.item.quality + 1;
        }
    }

    static void decreaseQuality(TypedItem item) {
        if (item.item.quality > 0) {
            item.item.quality = item.item.quality - 1;
        }
    }
}