package com.gildedrose;

import static com.gildedrose.Constants.*;

public class Item {

    private final String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void resetQuality() {
        this.quality = 0;
    }

    public void increaseQuality() {
        if (this.quality < HIGHEST_QUALITY) {
            this.quality++;
        }
    }

    public void decreaseQuality() {
        if (this.isCommon() && this.quality > 0) {
            this.quality--;
        }
    }

    public void decreaseSellIn() {
        if (this.isCommon()) {
            this.sellIn--;
        }
    }

    public boolean isCommon() {
        return !LEGENDARY_ITEMS.contains(this.name);
    }

    public boolean isAgingProduct() {
        return this.name.equals(AGED_BRIE)
            || this.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
