package com.gildedrose;

import static com.gildedrose.ItemType.LEGENDARY;

class TypedItem {
    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    ItemType type;
    private Item item;

    TypedItem(Item item, ItemType type) {
        this.item=item;
        this.type=type;
    }

    void increaseQuality() {
        if (this.item.quality < MAXIMUM_QUALITY) {
            this.item.quality += 1;
        }
    }

    void decreaseQuality() {
        if (this.item.quality > MINIMUM_QUALITY) {
            this.item.quality -= 1;
        }
    }

    int getQuality() {
        return this.item.quality;
    }

    void decreaseQualityToMinimum() {
        this.item.quality = MINIMUM_QUALITY;
    }

    int getSellIn() {
        return this.item.sellIn;
    }

    void updateSellIn() {
        this.item.sellIn -= 1;
    }
}