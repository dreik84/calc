package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackXTest {

    private StackX stackX;

    @BeforeEach
    void init() {
        stackX = new StackX(5);
    }

    @Test
    void pushPopTest() {
        char expected = 'z';
        stackX.push(expected);
        char actual = stackX.pop();

        assertEquals(expected, actual);
    }

    @Test
    void peekTest() {
        char expected = 'z';
        stackX.push(expected);
        char actual = stackX.peek();

        assertEquals(expected, actual);
    }

    @Test
    void peekNTest() {
        char expected = 'z';
        stackX.push(expected);
        char actual = stackX.peekN(0);

        assertEquals(expected, actual);
    }

    @Test
    void isEmptyTest() {
        assertTrue(stackX.isEmpty());
    }

    @Test
    void sizeTest() {
        stackX.push('z');
        int expected = 1;
        int actual = stackX.size();

        assertEquals(expected, actual);
    }
}
