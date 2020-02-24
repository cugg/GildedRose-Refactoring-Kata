package com.gildedrose;

import static com.gildedrose.ItemType.DEFAULT;

class TypedItemFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    static TypedItem createTypedItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedItem(item);
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new TicketItem(item);
            case SULFURAS_HAND_OF_RAGNAROS:
                return new LegendaryItem(item);
            default:
                return new TypedItem(item);
        }
    }
}
