package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    public void updateQuality() {
        this.sellIn -= 1;
        increaseItemQuality();

        if (this.sellIn <= 10) {
            increaseItemQuality();
        }

        if (this.sellIn <= 5) {
            increaseItemQuality();
        }

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }
}
