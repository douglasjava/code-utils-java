package com.example.demo.hundreddaysofjava;

import java.util.HashMap;
import java.util.Map;

/**
 * Day 54 - Computing Map values if absent.
 */
public class Day054 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");

//        Instead of doing:
//        String three = map.get(3);
//        if (three == null) {
//            three = "three";
//            map.put(3, three);
//        }

//        Just do:
        String three = map.computeIfAbsent(3, k -> "three");

        System.out.println(three);
        System.out.println(map);
    }

}
