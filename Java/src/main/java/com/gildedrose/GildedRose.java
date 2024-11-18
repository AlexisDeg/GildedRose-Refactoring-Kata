package com.gildedrose;

import java.util.Arrays;

import static com.gildedrose.Constants.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateStore() {
        Arrays.stream(items).forEach(item -> {
            updateSellIn(item);

            updateQuality(item);
        });
    }

    private static void updateQuality(Item item) {
        if (item.isAgingProduct()) {
            handleAgingProduct(item);
        } else {
            item.decreaseQuality();
            if (item.getSellIn() < 0) {
                item.decreaseQuality();
            }
        }
    }

    private static void handleAgingProduct(Item item) {

        item.increaseQuality();

        if (item.getName().equals(AGED_BRIE) && item.getSellIn() < 0) {
            item.increaseQuality();
        }

        if (item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            if (item.getSellIn() < SELL_IN_FIRST_THRESHOLD) {
                item.increaseQuality();
            }
            if (item.getSellIn() < SELL_IN_SECOND_THRESHOLD) {
                item.increaseQuality();
            }
            if (item.getSellIn() < 0) {
                item.resetQuality();
            }
        }
    }

    private static void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

}
