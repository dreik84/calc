package org.example;

/**
 * This class represents the implementation of the stack data structure
 * @author dreik84
 * @version 1.0.0
 */

public class StackX {

    private final char[] stackArray;
    private int top;

    public StackX(int s) {
        stackArray = new char[s];
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

    /**
     * This method returns the top element but does not remove it from the stack
     * @return The top element of the stack
     */
    public char peek() {
        return stackArray[top];
    }

    /**
     * This method checks that the stack is empty
     * @return True if the stack is empty and False otherwise
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * This method returns the number of elements in the stack
     * @return Integer number of elements
     */
    public int size() {
        return top + 1;
    }

    /**
     * This method returns the N element but does not remove it from the stack
     * @param n The index of the element to be returned
     * @return The N element of the stack
     */
    public char peekN(int n) {
        return stackArray[n];
    }

    /**
     * This method displays information about the stack contents in the console
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
