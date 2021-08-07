package com.example.demo.hundreddaysofjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day 65 - Reducing Verbosity of Generics With Diamond Operators
 */
public class Day065 {

    public static void main(String[] args) {
        // Instead of doing:
        Map<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();

        // Just do:
        Map<Integer, List<Integer>> map2 = new HashMap<>();
    }

}
