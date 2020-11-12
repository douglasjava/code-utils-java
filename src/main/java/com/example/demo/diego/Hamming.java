package com.example.demo.diego;

public class Hamming {

	int distance;
	String leftStrandUpperCase;
	String rightStrandUpperCase;

	public Hamming(String leftStrand, String rightStrand) {

		validateLeftStrandIsEmpty(leftStrand, rightStrand);
		validateRightStrandIsDifferentLeftStrand(leftStrand, rightStrand);
		validateLeftStrandIsDifferentRightStrand(leftStrand, rightStrand);

		this.leftStrandUpperCase = leftStrand.toUpperCase();
		this.rightStrandUpperCase = rightStrand.toUpperCase();

		if (isNotEqualsLeftStrandIsRightStrand()) {

			for (int i = 0; i < leftStrandUpperCase.length(); i++) {
				if (leftStrandUpperCase.charAt(i) != rightStrandUpperCase.charAt(i)) {
					this.distance++;
				}
			}
		}

	}

	private boolean isNotEqualsLeftStrandIsRightStrand() {
		return !(leftStrandUpperCase.equals("") && rightStrandUpperCase.equals(""));
	}

	public void validateLeftStrandIsEmpty(String leftStrand, String rightStrand) {
		if (leftStrand.isEmpty() && !rightStrand.isEmpty())
			throw new IllegalArgumentException("left strand must not be empty.");
	}

	public void validateRightStrandIsDifferentLeftStrand(String leftStrand, String rightStrand) {
		if (rightStrand.isEmpty() && !leftStrand.isEmpty())
			throw new IllegalArgumentException("right strand must not be empty.");
	}

	public void validateLeftStrandIsDifferentRightStrand(String leftStrand, String rightStrand) {
		if (leftStrand.length() != rightStrand.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
	}

	public int getHammingDistance() {
		return distance;
	}

}
