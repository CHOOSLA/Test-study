package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GopTest {

    @Test
    void multi() {
        Gop gop = new Gop();
        int result = gop.multi(10, 20);
        assertEquals(100, result);
    }

    @Test
    void multi2() {
        Gop gop = new Gop();
        int result = gop.multi(-1, 20);
        assertEquals(100, result);
    }
}