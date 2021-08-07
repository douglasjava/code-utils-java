package com.example.demo.hundreddaysofjava;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creating a thread pool to run tasks simultaneously and reuse threads.
 */
@Slf4j
public class Day008 {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        log.info("Creating a thread pool with 5 threads");
        ExecutorService executor = Executors.newFixedThreadPool(5);

        /*
         * Will submit 15 tasks. Note that there's only 5 threads to run all of them in our thread pool.
         * So the first 5 tasks will run simultaneously and 10 tasks will wait in the queue until a thread is available.
         */
        log.info("Starting tasks submissions.");
        try {
            for (var i = 1; i <= 15; i++) {
                int taskId = i;
                log.info(MessageFormat.format("Will submit task {0}.", taskId));
                executor.submit(() -> task(taskId));
            }
        } finally {
            executor.shutdown();
        }
    }

    private static void task(int taskId) {
        log.info(MessageFormat.format("Running task {0}.", taskId));
        simulateLongProcessing();
        log.info(MessageFormat.format("Task {0} has finished.", taskId));
    }

    /**
     * Metodo a ser executado
     */
    private static void simulateLongProcessing() {
        try {
            Thread.sleep((RANDOM.nextInt(3) + 10) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(MessageFormat.format("Thread {0} was interrupted.", Thread.currentThread().getName()), e);
        }
    }

}
