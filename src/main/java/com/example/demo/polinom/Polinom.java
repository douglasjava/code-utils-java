package com.example.demo.polinom;

import java.util.ArrayList;
import java.util.List;

/**
 * The method used to implement the polynomials.
 * @author Adrian Muntean
 * @see {@link #toString()},{@link #toStringDouble()},{@link #addMonom(Monom)},{@link #elimMonom(int)},{@link #isEmpty()},{@link #getMonom(int)},{@link #reset()}
 */
public class Polinom {
	//The list with the monoms forming the polynomial
	private List<Monom> argumente = new ArrayList<Monom>();
	private int nrMonoame = 0;//The number of the monoms 
	
	/**
	 * Method used to add monoms to polynomial.
	 * @param monom
	 */
	public void addMonom(Monom monom) {
		argumente.add(monom);
		nrMonoame++;
	}
	
	/**
	 * Method used to represent the polynomials as a String
	 * @return String 
	 */
	@Override
	public String toString(){
		
		String reprezentarePolinom = "";
		String auxP = "";
		String auxC = "";
		boolean areMonomPozitiv = false;//Used to check and display if the polynomial has the last coefficient 1
		
		for (Monom m : argumente){
			
			int coef = (int) m.getCoef();
			if(m.getCoef() == 0) continue;
			if((coef != 1) && (coef != -1)) auxC = coef + "";
			else if(coef == 1) {auxC = "";
							areMonomPozitiv = true;}
				else {auxC = "-"; 
				   	 
						}
			if((m.getPower() != 0) && (m.getPower() != 1)) auxP = "x^" + (int)m.getPower();
			else if(m.getPower() == 1) auxP = "x";
				else auxP = ""; 
			if(coef == 1 && m.getPower() == 0) auxC = "1";
			if(coef == -1 && m.getPower() == 0) auxC = "-1";
			
			reprezentarePolinom = reprezentarePolinom+ auxC + auxP + "+";
			reprezentarePolinom = reprezentarePolinom.replace("+-", "-");
		}
		if(reprezentarePolinom.compareTo("") == 0) 
				{if(areMonomPozitiv) reprezentarePolinom = "1";
				else reprezentarePolinom = "0"; 		
				}
		else if(reprezentarePolinom.length() > 0)
		reprezentarePolinom = reprezentarePolinom.substring(0,reprezentarePolinom.length()-1);
		reprezentarePolinom = reprezentarePolinom.replace("+-", "-");
		if(reprezentarePolinom.compareTo("-") == 0) reprezentarePolinom = "-1";
		if(argumente.isEmpty()) {reprezentarePolinom = "0";
								}
		return reprezentarePolinom;
	}
	
	/**
	 * Method used to represent the polynomials as a string.
	 * As oposed to {@link #toString()} this method is adding double values instead of integers. 
	 * @return double transformed into String
	 */
	public String toStringDouble() {
		String reprezentarePolinom = "";
		String auxP = "";
		String auxC = "";
		for (Monom m : argumente){
			
			if(m.getCoef() == 0) {System.out.println("a ajuns in continue");continue;}
			if((m.getCoef() != 1) && (m.getCoef() != -1)) auxC = String.format("%.2g%n", m.getCoef()) + "";
			else if(m.getCoef() == 1) auxC = "";
				else auxC = "-";
			if((m.getPower() != 0) && (m.getPower() != 1)) auxP = "x^" + (int)m.getPower();
			else if(m.getPower() == 1) auxP = "x";
					else auxP = ""; 
			reprezentarePolinom = reprezentarePolinom + auxC + auxP + "+";	
		}
		
		if(argumente.isEmpty()) 
			reprezentarePolinom = "0";
		if(reprezentarePolinom.compareTo("") == 0) reprezentarePolinom = "0";
		else if(reprezentarePolinom.length() > 0) 
		reprezentarePolinom = reprezentarePolinom.substring(0,reprezentarePolinom.length()-1);
		
		reprezentarePolinom = reprezentarePolinom.replace("+-", "-");
		
		return reprezentarePolinom;	}
/**
 * Returns the number of monoms
 * @return nrMonoms
 */
	public int nrMonoms() {
		return nrMonoame;	
	}
	
	/**
	 * Returns the monom found at index i.
	 * @param i
	 * @return One monom
	 */
	public Monom getMonom(int i){
		
		return argumente.get(i);
		
	}

	/**
	 * Method used to reset the polynomial
	 * @author Adrian Muntean
	 */
	public void reset() {
		argumente.clear();
		nrMonoame = 0;
	}

	/**
	 * Method used to eliminate one monom found at index i
	 * @param i
	 */
	public void elimMonom(int i) {
		argumente.remove(i);
		
	}

	/**
	 * Method which shows if one polynomial is empty or not.
	 * @return
	 */
	public boolean isEmpty() {
		if(argumente.isEmpty()) return true;
		else return false;
		
	}
}