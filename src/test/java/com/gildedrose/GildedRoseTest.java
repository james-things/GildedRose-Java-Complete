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
        Item testItem1 = new Item("Conjured Test Item", 10, 10); //declare test item
        Item testItem2 = new Item("Sulfuras or something", 10, 10);
        Item[] items = new Item[] { new Item("foo", 0, 0) }; //declare array (needed by gildedrose)
        GildedRose gr = new GildedRose(items);  //instantiate gildedrose
        assertFalse(gr.isConjured); //assert default is false
        gr.SetItemFlags(testItem1); //set flags using first TEST item
        assertTrue(gr.isConjured); //assert test item changed flag to true
        gr.SetItemFlags(testItem2); //set flags using second test item
        assertFalse(gr.isConjured); //assert test item unset previous flag
        assertTrue(gr.isLegendary); //assert test item set new flag
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
