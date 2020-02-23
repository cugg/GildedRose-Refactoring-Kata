package com.gildedrose;

import static com.gildedrose.ItemType.*;

public class TypedItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public ItemType type = DEFAULT;
    public Item item;
    public TypedItem(Item item) {
        this.item=item;
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
    }
}
