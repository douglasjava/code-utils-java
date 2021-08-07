package com.example.demo.hundreddaysofjava;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Day 6 - Running a task asynchronously.
 */
@Slf4j
public class Day006 {

    public static void main(String[] args) {
        CompletableFuture.runAsync(Day006::task);

        log.info("Message from the main thread. Note that this message is logged before the async task ends.");
        log.info("Waiting for the async task to end.");

        boolean isQuiecent = ForkJoinPool.commonPool().awaitQuiescence(5, SECONDS);

        if (isQuiecent) {
            log.info("Async task ended.");
        } else {
            log.error("The async task is taking too long to finish. This program will end anyway.");
        }

    }

    private static void task() {
        log.info("Async task starting. This message is logged by the async task thread");
        try {
            Thread.sleep(1000);
            log.info("Async task is ending. This message is logged by the async task thread");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            log.info("The async task thread was interrupted.", e);
        }
    }

}
