package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    private static GildedRose getGildedRose() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        return new GildedRose(items);
    }

    @Test
    void update_quality_once() {
        GildedRose gildedRose = getGildedRose();

        gildedRose.updateQuality();

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                19, 1, 6, 80, 80, 21, 50, 50
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                9, 1, 4, 0, -1, 14, 9, 4
            );

    }

    @Test
    void update_quality_twice() {
        GildedRose gildedRose = getGildedRose();

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                18, 2, 5, 80, 80, 22, 50, 50
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                8, 0, 3, 0, -1, 13, 8, 3
            );

    }

    @Test
    void update_quality_thrice() {
        GildedRose gildedRose = getGildedRose();

        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                17, 4, 4, 80, 80, 23, 50, 50
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                7, -1, 2, 0, -1, 12, 7, 2
            );

    }

    @Test
    void update_quality_ten_times() {
        GildedRose gildedRose = getGildedRose();

        for (int i = 0; i < 10; i++) {
            gildedRose.updateQuality();
        }

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                10, 18, 0, 80, 80, 35, 50, 0
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                0, -8, -5, 0, -1, 5, 0, -5
            );

    }

    @Test
    void update_quality_twenty_times() {
        GildedRose gildedRose = getGildedRose();

        for (int i = 0; i < 20; i++) {
            gildedRose.updateQuality();
        }

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                0, 38, 0, 80, 80, 0, 0, 0
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                -10, -18, -15, 0, -1, -5, -10, -15
            );

    }

    @Test
    void update_quality_fifty_times() {
        GildedRose gildedRose = getGildedRose();

        for (int i = 0; i < 50; i++) {
            gildedRose.updateQuality();
        }

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                0, 50, 0, 80, 80, 0, 0, 0
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                -40, -48, -45, 0, -1, -35, -40, -45
            );

    }

    @Test
    void update_quality_hundred_times() {
        GildedRose gildedRose = getGildedRose();

        for (int i = 0; i < 100; i++) {
            gildedRose.updateQuality();
        }

        assertThat(gildedRose.items)
            .extracting("name").containsExactly(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert");
        assertThat(gildedRose.items)
            .extracting("quality").containsExactly(
                0, 50, 0, 80, 80, 0, 0, 0
            );
        assertThat(gildedRose.items)
            .extracting("sellIn").containsExactly(
                -90, -98, -95, 0, -1, -85, -90, -95
            );

    }

}
