package com.example.demo.polinom;

/**
 * @author Adrian Muntean Class which implements the monom which is part of the
 *         polynomial class
 * @see {@link #getCoef()},{@link #getPower()},{@link #setCoef(double)},{@link #setPower(double)},{@link #div(Monom)}
 */

public class Monom {
	/**
	 * Coefficient field.
	 */
	private double coef;
	/**
	 * Power number field.
	 */
	private double power;

	Monom(double coef, double power) {
		setPower(power);
		setCoef(coef);
	}

	/**
	 * Method used to set the power.
	 * 
	 * @param power2
	 */
	public void setPower(double power2) {

		this.power = power2;

	}

	/**
	 * Method used to get the power.
	 * 
	 * @return power
	 */
	public double getPower() {
		return this.power;
	}

	/**
	 * Method used to divide one monom with another one
	 * 
	 * @param aux
	 * @return Monom
	 */
	public Monom div(Monom aux) {
		Monom imp = new Monom(this.coef / aux.getCoef(), power - aux.getPower());
		return imp;
	}

	/**
	 * Method used to set the coefficient
	 * 
	 * @param coef
	 */
	public void setCoef(double coef) {
		this.coef = coef;
	}

	/**
	 * Method used to get the coefficient
	 * 
	 * @return coefficient value
	 */
	public double getCoef() {
		return this.coef;
	}

}