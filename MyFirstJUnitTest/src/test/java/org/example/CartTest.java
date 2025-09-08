package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    @Test
    void testEmptyCart() {
        Cart cart = new Cart();
        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void testAddItem() {
        Cart cart = new Cart();
        cart.addItem("item1");
        assertFalse(cart.isEmpty());
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testGetItemsAsArray() {
        Cart cart = new Cart();
        cart.addItem("바나나");
        cart.addItem("양파");

        String[] items = cart.getItemsAsArray();
        assertEquals(2, items.length);
        assertEquals("바나나", items[0]);
        assertEquals("양파", items[1]);
    }
}
