package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {

    public static void main(String[] args) throws IOException {
        String input;
        String output;
        int result;

        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();

            if (input.isEmpty()) {
                break;
            }
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();
            ParsePost aParser = new ParsePost(output);
            result = aParser.doParse();
            System.out.println("Postfix is " + output + " = " + result + "\n");
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        return br.readLine();
    }
}
