package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("foo", app.getItem(0).getName());
    }

    @Test
    void updateQuality() {
    }

    @Test
    void getItems() {
    }

    @Test
    void getItem() {
    }
}
