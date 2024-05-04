package com.example.demo.entendendo_algoritmos;

import java.util.*;

public class gulosos {

    public static void main(String[] args) {
        Set<String> statesInclude = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kum", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("kdois", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("ktres", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kquatro", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kcinco", new HashSet<>(Arrays.asList("ca", "az")));

        Set<String> stationsFinal = new HashSet<>();
        String betterStation;
        Set<String> statesCovered;

        while (!statesInclude.isEmpty()) {
            betterStation = null;
            statesCovered = new HashSet<>();

            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                Set<String> statesStation = entry.getValue();
                Set<String> covered = new HashSet<>(statesInclude);
                covered.retainAll(statesStation); // interseção

                if (covered.size() > statesCovered.size()) {
                    betterStation = entry.getKey();
                    statesCovered = covered;
                }
            }

            statesInclude.removeAll(statesCovered);
            stationsFinal.add(betterStation);
        }

        System.out.println(stationsFinal);
    }

}
