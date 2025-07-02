package org.example;

public class ParsePost {

    private final String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        StackX theStack = new StackX(20);
        char ch;
        int i;
        int num1;
        int num2;
        int interAns;

        for (i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            theStack.displayStack(ch + " ");

            if (ch >= '0' && ch <= '9') {
                theStack.push(ch);
            } else {
                num2 = Character.getNumericValue(theStack.pop());
                num1 = Character.getNumericValue(theStack.pop());

                interAns = switch (ch) {
                    case '+' -> num1 + num2;
                    case '-' -> num1 - num2;
                    case '*' -> num1 * num2;
                    case '/' -> num1 / num2;
                    default -> 0;
                };
                theStack.push(Character.forDigit(interAns, 10));
            }
        }
        interAns = Character.getNumericValue(theStack.pop());
        return interAns;
    }
}
