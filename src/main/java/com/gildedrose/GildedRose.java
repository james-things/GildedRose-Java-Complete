package com.gildedrose;

class GildedRose {
    private Item[] items;
    private boolean isExpired;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void UpdateQuality() {
        for (Item item : items) {
            isExpired = CheckExpiration(item);

            if (item.getAges() && !isExpired)
                UpdateAgingQuality(item);
            if (item.getConjured() && !isExpired)
                UpdateConjuredQuality(item);
            if (!item.getAges() && !item.getLegendary() && !item.getConjured() && !isExpired)
                UpdateNormalQuality(item);

            ApplyQualityLimits(item);

            if (!item.getLegendary())
                DecrementSellIn(item);
        }
    }

    private void UpdateAgingQuality(Item item) {
        if (item.getSellIn() > 10)
            item.setQuality(item.getQuality() + 1);
        if (item.getSellIn() <= 10 && item.getSellIn() > 5)
            item.setQuality(item.getQuality() + 2);
        if (item.getSellIn() <= 5 && item.getSellIn() > 0)
            item.setQuality(item.getQuality() + 3);
    }

    private void UpdateConjuredQuality(Item item) {
        item.setQuality(item.getQuality() - 2);
    }

    private void UpdateNormalQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    private void ApplyQualityLimits(Item item) {
        if (item.getQuality() > 50)
            item.setQuality(50);
        if (item.getQuality() < 0)
            item.setQuality(0);
    }

    private void DecrementSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    private boolean CheckExpiration(Item item) {
        if (item.getSellIn() <= 0 && !item.getLegendary())
            item.setQuality(0);
        return (item.getQuality() <= 0);
    }

    public Item[] getItems() {
        return this.items;
    }

    public Item getItem(int index) {
        return this.items[index];
    }

    //additional features below here
}
