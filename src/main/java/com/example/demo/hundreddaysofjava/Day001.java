package com.example.demo.hundreddaysofjava;

import java.security.SecureRandom;

import lombok.extern.slf4j.Slf4j;

/**
 * Day 1 - Generating a random number within a specific range.
 */
@Slf4j
public class Day001 {

	public static final SecureRandom SECURE_RANDOM = new SecureRandom();

	public static void main(String[] args) {
		log.info("Generating a number between 50 and 100....");
		log.info("{}", randomNumberBetween(50, 100));
	}

	private static final int randomNumberBetween(int minium, int maxium) {
		return SECURE_RANDOM.nextInt(maxium - minium) + minium;
	}

}
