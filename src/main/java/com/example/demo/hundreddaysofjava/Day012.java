package com.example.demo.hundreddaysofjava;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * Day 12 - Using Callable and Future to run tasks in parallel.
 */
@Slf4j
public class Day012 {

    public static void main(String[] args) throws InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();

        try {
            Callable<Integer> callable = Day012::doALongCalculation;
            Future<Integer> future = executorService.submit(callable);

            doOtherThingWhileCalculating();

            log.info("Will get the calculated value. Note that the value will be get immediately");
            log.info("Calculated value: " + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static int doALongCalculation() throws InterruptedException {
        Thread.sleep(5000L);
        return 42;
    }

    private static void doOtherThingWhileCalculating() throws InterruptedException {
        Thread.sleep(7000L);
    }

}
