package com.gildedrose;

public class Item {

    private String name;
    private int sellIn, quality;
    private boolean ages, legendary, conjured = false;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;

        if (name.contains("Aged Brie") || name.contains("concert"))
            this.ages = true;
        if (name.contains("Sulfuras"))
            this.legendary = true;
        if (name.contains("Conjured"))
            this.conjured = true;
    }

    public String getName() { return this.name;}

    public boolean getAges() { return this.ages; }
    public boolean getLegendary() { return this.legendary; }
    public boolean getConjured() { return this.conjured; }

    public int getSellIn() { return this.sellIn; }
    public int getQuality() { return this.quality; }

    public void setSellIn(int si) { this.sellIn = si; }
    public void setQuality(int q) { this.quality = q; }

   @Override
   public String toString() {
        return String.format("%-50s %-10s %-10s %-10s %-10s %-10s", this.name, this.sellIn, this.quality, this.ages,
            this.legendary, this.conjured);
    }
}
