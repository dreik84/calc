package org.example;

/**
 * This class represents the implementation of the stack data structure
 * @author dreik84
 * @version 1.0.0
 */

public class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    /**
     * This method pushes a new value onto the stack
     * @param j The value to put on the stack
     */
    public void push(char j) {
        stackArray[++top] = j;
    }

    /**
     * This method retrieves a value from the stack
     * @return The top element of the stack
     */
    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public char peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.println(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i) + " ");
        }
        System.out.println();
    }
}
