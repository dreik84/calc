package org.example;

public class InToPost {

    private final StackX theStack;
    private final String input;
    private String output;

    public InToPost(String in) {
        input = in;
        output = "";
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }

    public String doTrans() {

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);
            theStack.displayStack("For " + ch + " "); // diagnostic

            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);  // 1 - priority
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);  // 2 - priority
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
            }
        }

        while (!theStack.isEmpty()) {

            theStack.displayStack("While "); // diagnostic
            output = output + theStack.pop();
        }
        theStack.displayStack("End ");

        return output;
    }

    private void gotOper(char opThis, int prec1) {

        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();

            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;

                if (opTop == '+' || opTop == '-')  {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch) {

        while (!theStack.isEmpty()) {

            char chx = theStack.pop();

            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }
}
