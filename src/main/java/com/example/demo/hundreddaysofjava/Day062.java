package com.example.demo.hundreddaysofjava;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Day 62 - Converting JSON to Object and Object to JSON using Jakarta JSON Binding (JSON-B).
 */
public class Day062 {


    public static void main(String[] args) throws Exception {
        Musician steveHarris = new Musician("Steve Harris", "Bass", "England", "Iron Maiden");
        Musician michaelSchenker = new Musician("Michael Schenker", "Guitar", "Germany", "UFO");
        Musician daveLombardo = new Musician("Dave Lombardo", "Drums", "Cuba", "Slayer");

        List<Musician> musicians = List.of(steveHarris, michaelSchenker, daveLombardo);

        try (Jsonb jsonb = JsonbBuilder.create()) {
            String json = jsonb.toJson(musicians);
            System.out.println(json);

            String jsonJohnLord = "{\"bandName\":\"Deep Purple\",\"country\":\"England\",\"instrument\":\"Keyboards\",\"name\":\"John Lord\"}";

            Musician johnLord = jsonb.fromJson(jsonJohnLord, Musician.class);

            System.out.println(johnLord);
        }
    }


    @AllArgsConstructor
    @ToString
    public static class Musician {
        private String name;
        private String instrument;
        private String country;
        private String bandName;
    }
}
