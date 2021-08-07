package com.example.demo.hundreddaysofjava;

import java.util.List;

/**
 * Day 58 - Never write code that depends on toString() format
 */
public class Day058 {

    static class Bad {

        /**
         * Never write code that depends on {@link Object#toString()} format.
         * The format can change in the future and break your code.
         * In this particular case, we don't even know the {@link List} implementation that we're receiving,
         * and we don't have any guarantee that the return of {@link List#toString()} would be in the expected format.
         */
        public String convertToString(List<String> list) {
            return list.toString().replace("[", "").replace("]", "");
        }
    }

    static class Good {

        public String convertToString(List<String> list) {
            return String.join(", ", list);
        }
    }

}
