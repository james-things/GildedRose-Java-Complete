package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    protected boolean isNormal;
    protected boolean isAging;
    protected boolean isLegendary;
    protected boolean isConjured;

    //no arg constructor
    public GildedRose() {}

    //arg constructor
    public GildedRose(Item[] items) {
        this.items = items;
    }

    //set items to passed array
    protected void setItems(Item[] items) {
        this.items = items;
    }

    //processes all items and updates their quality using the appropriate method for the given item type
    public void updateQuality() {
        for (Item item : items) {
            setItemFlags(item);

            if (this.isAging)
                updateAgingQuality(item);
            if (this.isConjured)
                updateConjuredQuality(item);
            if (this.isNormal)
                updateNormalQuality(item);

            applyQualityLimits(item);

            if (!this.isLegendary)
                decrementSellIn(item);
        }
    }

    //set flags appropriate for the passed item
    protected void setItemFlags(Item item) {
        this.isAging = item.name.contains("Aged Brie") || item.name.contains("concert");
        this.isLegendary = item.name.contains("Sulfuras");
        this.isConjured = item.name.contains("Conjured");
        this.isNormal = (!this.isAging && !this.isLegendary && !this.isConjured);
    }

    //update the quality of an item which ages
    protected void updateAgingQuality(Item item) {
        if (item.sellIn > 10)
            item.quality = item.quality + 1;
        if (item.sellIn <= 10 && item.sellIn > 5)
            item.quality = item.quality + 2;
        if (item.sellIn <= 5 && item.sellIn > 0)
            item.quality = item.quality + 3;
        if (item.sellIn <= 0)
            item.quality = 0;
    }

    //update the quality of a conjured item
    protected void updateConjuredQuality(Item item) {
        item.quality -= ((item.sellIn <= 0) ? 4 : 2);
    }

    //update the quality of a normal item
    protected void updateNormalQuality(Item item) {
        item.quality -= ((item.sellIn <= 0) ? 2 : 1);
    }

    //reduce sellIn by 1
    protected void decrementSellIn(Item item) {
        item.sellIn -= 1;
    }

    //apply hard quality limits
    public void applyQualityLimits(Item item) {
        if (this.isLegendary)
            item.quality = 80;
        if (item.quality > 50 && !this.isLegendary)
            item.quality = 50;
        if (item.quality < 0)
            item.quality = 0;
    }

    //new features

    //Create a new item array and add the passed item on to the end of it
    protected void addItem(Item item) {
        int curSize = this.items.length;
        Item[] newArray = new Item[curSize + 1];
        for (int i = 0; i < curSize; i++)
            newArray[i] = this.items[i];
        newArray[curSize] = item;
        this.items = newArray;
    }

    protected String getTypeString(Item item) {
        setItemFlags(item);
        if (this.isAging)
            return "aging";
        if (this.isConjured)
            return "conjured";
        if (this.isLegendary)
            return "legendary";
        return "normal";
    }

    protected String getItemsAsString() {
        String itemString = "";
        for (Item i : this.items) {
            itemString += String.format("\n %-50s %-10s %-10s %-10s",
                i.name, i.quality, i.sellIn, "("+getTypeString(i)+")");
        }
        return itemString;
    }

    protected void setDemoItemData() {
        Item conjuredItem = new Item("Conjured Magical Dagger", 10, 45);
        Item legendaryItem = new Item("Sulfuras, Sword of the Somethingerather", 0, 80);
        Item normalItem = new Item("Normal Apple", 10, 5);
        Item brieAgedItem = new Item("Aged Brie with Peaches", 10, 30);
        Item concertAgedItem = new Item("Superbard concert tickets",7, 10);

        this.items = new Item[]{conjuredItem, legendaryItem, normalItem, brieAgedItem, concertAgedItem};
    }
}
