package com.example.demo.hundreddaysofjava;

import java.util.List;

/**
 * Day 27 - Printing a List: one item per line.
 */
public class Day027 {

    public static void main(String[] args) {
        List<Player> players = createList();

        String message = players.stream()
                .map(Player::toString)
                .reduce((p1, p2) -> p1 + System.lineSeparator() + p2)
                .orElse("");

        System.out.println(message);

        //other type
        players.stream().map(Player::toString).forEach(System.out::println);

    }

    private static List<Player> createList() {
        Player messi = new Player("Lionel Messi", "Barcelona", "Argentina", 42);
        Player cr7 = new Player("Cristiano Ronaldo", "Juventus", "Portugal", 50);
        Player neymar = new Player("Neymar Jr.", "PSG", "Brazil", 41);

        return List.of(messi, cr7, neymar);
    }

    private record Player(String name, String club, String coutry, int numberOfGoals) {
    }

}
