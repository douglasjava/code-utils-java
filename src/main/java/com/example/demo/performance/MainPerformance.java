package com.example.demo.performance;

public class MainPerformance {

	public static void main(String[] args) {

		StringPerformance sp = new StringPerformance();

		sp.benchmarkStringConstructor();

		sp.benchmarkStringLiteral();

	}

}
