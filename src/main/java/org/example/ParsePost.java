package org.example;

public class ParsePost {

    private StackX theStack;
    private final String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        theStack = new StackX(20);
        char ch;
        int i;
        int num1;
        int num2;
        int interAns;

        for (i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            theStack.displayStack("" + ch + " ");

            if (ch >= '0' && ch <= '9') {
                theStack.push(ch);
            } else {
                num2 = Character.getNumericValue(theStack.pop());
                num1 = Character.getNumericValue(theStack.pop());

                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(Character.forDigit(interAns, 10));
            }
        }
        interAns = Character.getNumericValue(theStack.pop());
        return interAns;
    }
}
