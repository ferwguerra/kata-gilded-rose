package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    GildedRose gildedRose;

    @Test
    public void dexterity_vest() {
        Item[] items = new Item[]{new CommonItem("+5 Dexterity Vest", 10, 20)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("+5 Dexterity Vest", gildedRose.items[0].name);
        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(19, gildedRose.items[0].quality);
    }

    @Test
    public void aged_brie() {
        Item[] items = new Item[]{new AgedBrie(2, 0)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Aged Brie", gildedRose.items[0].name);
        assertEquals(1, gildedRose.items[0].sellIn);
        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    public void elixir_of_the_mongoose() {
        Item[] items = new Item[]{new CommonItem("Elixir of the Mongoose", 5, 7)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Elixir of the Mongoose", gildedRose.items[0].name);
        assertEquals(4, gildedRose.items[0].sellIn);
        assertEquals(6, gildedRose.items[0].quality);
    }

    @Test
    public void sulfuras_hand_of_ragnaros() {
        Item[] items = new Item[]{new Sulfuras(0, 80)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.items[0].name);
        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    public void sulfuras_hand_of_ragnaros_negative_sell_in() {
        Item[] items = new Item[]{new Sulfuras(-1, 80)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.items[0].name);
        assertEquals(-1, gildedRose.items[0].sellIn);
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    public void backstage_passes() {
        Item[] items = new Item[]{new BackstagePasses(15, 20)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
        assertEquals(14, gildedRose.items[0].sellIn);
        assertEquals(21, gildedRose.items[0].quality);
    }

    @Test
    public void backstage_passes_limit_quality() {
        Item[] items = new Item[]{new BackstagePasses(10, 49)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void backstage_passes_limit_quality_sell_in_five_days() {
        Item[] items = new Item[]{new BackstagePasses(5, 49)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
        assertEquals(4, gildedRose.items[0].sellIn);
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void conjured_item() {
        Item[] items = new Item[]{new Conjured("Conjured Mana Cake", 3, 6)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Conjured Mana Cake", gildedRose.items[0].name);
        assertEquals(2, gildedRose.items[0].sellIn);
        assertEquals(4, gildedRose.items[0].quality);
    }

    @Test
    public void conjured_item_sell_by_date_passed() {
        Item[] items = new Item[]{new Conjured("Conjured Mana Cake", -1, 6)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("Conjured Mana Cake", gildedRose.items[0].name);
        assertEquals(-2, gildedRose.items[0].sellIn);
        assertEquals(2, gildedRose.items[0].quality);
    }

}
