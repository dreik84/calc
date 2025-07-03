package org.example;

import org.example.exception.EmptyStackXException;
import org.example.exception.NoSuchElementStackXException;
import org.example.exception.StackXOverflowException;

/**
 * This class represents the implementation of the stack data structure.
 *
 * @author dreik84
 * @version 1.0.0
 */

public class StackX {

    private final char[] stackArray;
    private int top;

    public StackX(int size) {
        stackArray = new char[size];
        top = -1;
    }

    /**
     * This method pushes a new value onto the stack.
     *
     * @param j The value to put on the stack
     * @throws StackXOverflowException – if this stack is full.
     */
    public void push(char j) {

        if (isFull()) {
            throw new StackXOverflowException();
        }

        stackArray[++top] = j;
    }

    /**
     * This method retrieves a value from the stack.
     *
     * @return The top element of the stack
     * @throws EmptyStackXException – if this stack is empty.
     */
    public char pop() {

        if (isEmpty()) {
            throw new EmptyStackXException();
        }

        return stackArray[top--];
    }

    /**
     * This method returns the top element but does not remove it from the stack.
     *
     * @return The top element of the stack
     * @throws EmptyStackXException – if this stack is empty.
     */
    public char peek() {

        if (isEmpty()) {
            throw new EmptyStackXException();
        }

        return stackArray[top];
    }

    /**
     * This method checks that the stack is empty.
     *
     * @return True if the stack is empty and False otherwise
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * This method checks that the stack is full.
     *
     * @return True if the stack is full and False otherwise
     */
    public boolean isFull() {
        return (top == stackArray.length - 1);
    }

    /**
     * This method returns the number of elements in the stack.
     *
     * @return Integer number of elements
     */
    public int size() {
        return top + 1;
    }

    /**
     * This method returns the N element but does not remove it from the stack.
     *
     * @param n The index of the element to be returned
     * @return The N element of the stack
     * @throws NoSuchElementStackXException - if there is no element with the specified index in the stack
     */
    public char peekN(int n) {

        if (n > top) {
            throw new NoSuchElementStackXException();
        }

        return stackArray[n];
    }

    /**
     * This method displays information about the stack contents in the console.
     *
     * @param s String that will be displayed in the console
     */
    public void displayStack(String s) {
        System.out.println(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i) + " ");
        }
        System.out.println();
    }
}
