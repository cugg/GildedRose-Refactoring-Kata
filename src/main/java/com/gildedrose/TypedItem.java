package com.gildedrose;

import static com.gildedrose.ItemType.*;

public class TypedItem {
    public static final int MINIMUM_QUALITY = 0;
    public static final int MAXIMUM_QUALITY = 50;

    public ItemType type;
    public Item item;

    public TypedItem(Item item, ItemType type) {
        this.item=item;
        this.type=type;
    }

    public void increaseQuality() {
        if (this.item.quality < MAXIMUM_QUALITY) {
            this.item.quality += 1;
        }
    }

    public void decreaseQuality() {
        if (this.item.quality > MINIMUM_QUALITY) {
            this.item.quality -= 1;
        }
    }

    public int getQuality() {
        return this.item.quality;
    }

    public void decreaseQualityToMinimum() {
        this.item.quality = MINIMUM_QUALITY;
    }
}
