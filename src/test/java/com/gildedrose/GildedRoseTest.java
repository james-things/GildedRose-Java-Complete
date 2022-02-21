package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.UpdateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void getItems() {
    }

    @Test
    void getItem() {
    }

    @Test
    void updateQuality() {
    }

    @Test
    void setItemFlags() {
        Item testItem = new Item("Conjured Test Item", 10, 10);
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose gr = new GildedRose(items);
        assertFalse(gr.isConjured);
        gr.SetItemFlags(testItem);
        assertTrue(gr.isConjured);
    }

    @Test
    void updateAgingQuality() {
    }

    @Test
    void updateConjuredQuality() {
    }

    @Test
    void updateNormalQuality() {
    }

    @Test
    void decrementSellIn() {
    }

    @Test
    void applyQualityLimits() {
    }
}
