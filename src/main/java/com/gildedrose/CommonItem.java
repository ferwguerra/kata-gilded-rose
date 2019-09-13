package com.gildedrose;

public class CommonItem extends Item {
    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        this.sellIn -= 1;
        decreaseItemQuality();
        if (this.sellIn < 0) {
            decreaseItemQuality();
        }
    }
}
