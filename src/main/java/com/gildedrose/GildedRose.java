package com.gildedrose;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        updateQualityWhenExpired(item);
    }

    private void updateQualityWhenExpired(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                increaseQuality(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateAgedBrieAndBackstagePassQuality(item);
        } else {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseQuality(item);
            }
        }
    }

    private void updateAgedBrieAndBackstagePassQuality(Item item) {
        increaseQuality(item);

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }

    }

    static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}