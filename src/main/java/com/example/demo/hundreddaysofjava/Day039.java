package com.example.demo.hundreddaysofjava;

/**
 * Day 39 - Understanding the Prefix (i) and Postfix (i) Operators
 */
public class Day039 {

    public static void main(String[] args) {
        int i = 0;

        while (i < 3) {
            System.out.println("Valor i++  ==> " + i);
            System.out.println(i++); //i++ means use i and then increment i
        }

        System.out.println("----------------------------");

        i = 0;
        while (i < 3) {
            System.out.println("Valor ++i  ==> " + i);
            System.out.println(++i); //++i means increment i and then use i
        }
    }

}
