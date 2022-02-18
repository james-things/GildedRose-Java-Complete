package com.gildedrose;

class GildedRose {
    Item[] items;
    private boolean isExpired, isNormal, isAging, isLegendary, isConjured;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //processes all items and updates their quality using the appropriate method for the given item type
    public void UpdateQuality() {
        for (Item item : items) {
            SetItemFlags(item);

            isExpired = CheckExpiration(item);

            if (this.isAging)
                UpdateAgingQuality(item);
            if (this.isConjured)
                UpdateConjuredQuality(item);
            if (this.isNormal)
                UpdateNormalQuality(item);

            ApplyQualityLimits(item);

            if (!this.isLegendary)
                DecrementSellIn(item);
        }
    }

    //update the quality of an item which ages
    private void UpdateAgingQuality(Item item) {
        if (item.sellIn > 10)
            item.quality = item.quality + 1;
        if (item.sellIn <= 10 && item.sellIn > 5)
            item.quality = item.quality + 2;
        if (item.sellIn <= 5 && item.sellIn > 0)
            item.quality = item.quality + 3;
        if (isExpired)
            item.quality = 0;
    }

    //update the quality of a conjured item
    private void UpdateConjuredQuality(Item item) {
        item.quality -= ((isExpired) ? 4 : 2);
    }

    //update the quality of a normal item
    private void UpdateNormalQuality(Item item) {
        item.quality -= ((isExpired) ? 2 : 1);
    }

    //reduce sellIn by 1
    private void DecrementSellIn(Item item) {
        item.sellIn -= 1;
    }

    //set flags appropriate for the passed item
    private void SetItemFlags(Item item) {
        this.isAging = item.name.contains("Aged Brie")
            || item.name.contains("concert");
        this.isLegendary = item.name.contains("Sulfuras");
        this.isConjured = item.name.contains("Conjured");
        this.isNormal = (!this.isAging && !this.isLegendary && !this.isConjured);
    }

    //reduce quality to zero if not legendary and expired, returns boolean isExpired
    private boolean CheckExpiration(Item item) {
        if (item.sellIn <= 0 && !this.isLegendary)
            item.quality = 0;
        return (item.quality <= 0);
    }

    //apply hard quality limits
    public void ApplyQualityLimits(Item item) {
        if (this.isLegendary)
            item.quality = 80;
        if (item.quality > 50 && !this.isLegendary)
            item.quality = 50;
        if (item.quality < 0)
            item.quality = 0;
    }
}
