package com.gildedrose;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
    }

    protected void decreaseItemQuality() {
        if (this.quality > 0) {
            this.quality -= 1;
        }
    }

    protected void increaseItemQuality() {
        if (this.quality < 50) {
            this.quality += 1;
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
