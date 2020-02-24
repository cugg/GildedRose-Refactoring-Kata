package com.gildedrose;

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
    }
}