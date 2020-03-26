package com.gildedrose;

class TypedItem {
    static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;
    private static final String CONJURED = "conjured ";

    private Item item;
    private int conjuredTimes;

    TypedItem(Item item) {
        this.item = item;
        this.conjuredTimes = countConjuredTimes(item.name.toLowerCase());
    }

    void increaseQuality() {
        if (this.item.quality < MAXIMUM_QUALITY) {
            this.item.quality += 1;
        }
    }

    void decreaseQuality() {
        if (this.item.quality > MINIMUM_QUALITY) {
            this.item.quality -= 1 << conjuredTimes;
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

    private static int countConjuredTimes(final String str) {
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(TypedItem.CONJURED, idx)) != -1) {
            count++;
            idx += TypedItem.CONJURED.length();
        }
        return count;
    }

    public boolean isConjured() {
        return conjuredTimes > 0;
    }
}
