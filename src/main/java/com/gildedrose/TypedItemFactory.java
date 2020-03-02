package com.gildedrose;

class TypedItemFactory {
    private static final String AGED_BRIE = "aged brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "backstage passes to a tafkal80etc concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "sulfuras, hand of ragnaros";
    private static final String CONJURED = "conjured ";

    static TypedItem createTypedItem(Item item) {
        String unconjuredItemName = item.name.toLowerCase().replaceAll(CONJURED, "");

        switch (unconjuredItemName) {
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
