package org.example;

import org.example.exception.EmptyStackXException;
import org.example.exception.NoSuchElementStackXException;
import org.example.exception.StackXOverflowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackXTest {

    private StackX stackX;

    @BeforeEach
    void init() {
        stackX = new StackX(2);
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

    @Test
    void pushTestThrown() {
        assertThrows(StackXOverflowException.class, () -> {
            stackX.push('x');
            stackX.push('y');
            stackX.push('z');
        });
    }

    @Test
    void popTestThrown() {
        assertThrows(EmptyStackXException.class, stackX::pop);
    }

    @Test
    void peekTestThrown() {
        assertThrows(EmptyStackXException.class, stackX::peek);
    }

    @Test
    void peekNTestThrown() {
        assertThrows(NoSuchElementStackXException.class, () -> stackX.peekN(0));
    }
}
