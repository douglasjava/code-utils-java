package com.example.demo.hundreddaysofjava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Day 28 - Sorting a List by a specific attribute.
 */
public class Day028 {

    public static void main(String[] args) {
        Player messi = new Player("Lionel Messi", "Barcelona", "Argentina", 42);
        Player cr7 = new Player("Cristiano Ronaldo", "Juventus", "Portugal", 50);
        Player neymar = new Player("Neymar Jr.", "PSG", "Brazil", 41);

        List<Player> players = Arrays.asList(messi, cr7, neymar);

        players.sort(Comparator.comparing(Player::numberOfGoals).reversed());

        System.out.println("Top Scorers:");
        players.forEach(System.out::println);
    }

    private record Player(String name, String club, String coutry, int numberOfGoals) {
    }

}
