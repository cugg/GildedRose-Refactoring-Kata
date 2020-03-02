package com.gildedrose;

class TypedItemFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "conjured";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static TypedItem createTypedItem(Item item, int conjuredFactor) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedItem(item, conjuredFactor);
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new TicketItem(item, conjuredFactor);
            case SULFURAS_HAND_OF_RAGNAROS:
                return new LegendaryItem(item, conjuredFactor);
            default:
                if(item.name.toLowerCase().startsWith(CONJURED)){
                    return createTypedItem(new Item(item.name.substring("conjured ".length()), item.sellIn, item.quality),
                            conjuredFactor * 2);
                } else {
                    return new TypedItem(item, conjuredFactor);
                }
        }
    }

    static TypedItem createTypedItem(Item item) {
        return createTypedItem(item, 1);
    }
}
