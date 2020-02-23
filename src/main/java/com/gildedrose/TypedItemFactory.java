package com.gildedrose;

import static com.gildedrose.ItemType.*;

public class TypedItemFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public static TypedItem createTypedItem(Item item) {
        ItemType type = DEFAULT;
        switch (item.name) {
            case AGED_BRIE:
                type = AGED;
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                type = TICKET;
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                type = LEGENDARY;
                break;
            default:
                break;
        }
        return new TypedItem(item, type);
    }
}
