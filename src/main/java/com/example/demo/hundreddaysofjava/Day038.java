package com.example.demo.hundreddaysofjava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Day 38 - Supplying a default value in case of timeout when running an async task.
 */
public class Day038 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String webSite = CompletableFuture.supplyAsync(Day038::getWebSite)
                .completeOnTimeout("https://twitter.com/helber_belmiro", 5, SECONDS)
                .get();

        System.out.println(webSite);
    }

    private static String getWebSite() {
        try {
            Thread.sleep(10_000);
            return "thegreatapi.com";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
