package com.example.demo.hundreddaysofjava;

import java.util.EnumMap;
import java.util.Map;

/**
 * Day 67 - Use EnumMap When the Key of Your Map Is an Enum
 */
public class Day067 {

    public static void main(String[] args) {
        /*
        Use EnumMap when the key of your Map is an enum.
        EnumMap is more efficient than HashMap.
         */
        Map<Color, String> portugueseColors = new EnumMap<>(Color.class);
        portugueseColors.put(Color.RED, "Vermelho");
        portugueseColors.put(Color.YELLOW, "Amarelo");
        portugueseColors.put(Color.BLUE, "Azul");
    }

    enum Color {
        RED,
        YELLOW,
        BLUE
    }

}
