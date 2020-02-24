package com.gildedrose;

import static com.gildedrose.ItemType.*;

class TypedItem {
    static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    private ItemType type;
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

    private void decreaseQualityToMinimum() {
        this.item.quality = MINIMUM_QUALITY;
    }

    int getSellIn() {
        return this.item.sellIn;
    }

    void aging() {
        this.item.sellIn -= 1;
        if (getSellIn() < 0) {
            updateQualityWhenExpired();
        }
    }

    private void updateQualityWhenExpired() {
        if (type.equals(AGED)) {
            increaseQuality();
        } else if (type.equals(TICKET)) {
            decreaseQualityToMinimum();
        } else if (type.equals(LEGENDARY)) {
            return;
        } else {
            decreaseQuality();
        }
    }

    void updateQuality() {
        decreaseQuality();
    }
}
