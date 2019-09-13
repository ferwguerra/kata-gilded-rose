package com.gildedrose;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        this.sellIn -= 1;
        decreaseItemQuality();
        decreaseItemQuality();
        if (this.sellIn < 0) {
            decreaseItemQuality();
            decreaseItemQuality();
        }
    }
}
