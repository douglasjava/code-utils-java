package com.example.demo.hundreddaysofjava;

import java.text.MessageFormat;

/**
 * Formatting a message using MessageFormat.
 */
public class Day007 {

    public static void main(String[] args) {
        showMessage("Java", "is", "great");
    }

    private static void showMessage(String param1, String param2, String param3) {
        String message = MessageFormat.format("This message contains 3 parameters. The #1 is ''{0}'', the #2 is ''{1}'', and the #3 is ''{2}''.",
                param1, param2, param3);
        System.out.println(message);
    }


}
