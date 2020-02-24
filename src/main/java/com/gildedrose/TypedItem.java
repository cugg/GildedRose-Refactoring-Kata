package com.gildedrose;

class TypedItem {
    static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    private Item item;

    TypedItem(Item item) {
        this.item = item;
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

    int getSellIn() {
        return this.item.sellIn;
    }

    void aging() {
        this.item.sellIn -= 1;
        if (isExpired()) {
            updateQualityWhenExpired();
        }
    }

    private boolean isExpired() {
        return getSellIn() < 0;
    }

    void updateQualityWhenExpired() {
        decreaseQuality();
    }

    void updateQuality() {
        decreaseQuality();
    }

    void decreaseQualityToMinimum() {
        this.item.quality = MINIMUM_QUALITY;
    }

    void update() {
        updateQuality();
        aging();
    }

}
