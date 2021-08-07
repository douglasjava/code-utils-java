package com.example.demo.hundreddaysofjava;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * Day 3 - Scheduling a task to run every 2 seconds.
 */
@Slf4j
public class Day003 {

	private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) throws InterruptedException {

		var day003 = new Day003();
		day003.printCurrentTimeEvery2Seconds();
		Thread.sleep(15_000);
		day003.stopPrinting();

	}

	public void printCurrentTimeEvery2Seconds() {
		Runnable task = () -> log.info("{}", LocalTime.now());
		executorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	}

	public void stopPrinting() {
		executorService.shutdown();
	}

}
