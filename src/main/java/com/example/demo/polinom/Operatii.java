package com.example.demo.polinom;

/**
 * The class which implements the operations.
 * 
 * @author Adrian Muntean
 * @see {@link #sub(Polinom, Polinom)},{@link #div(Polinom, Polinom)},{@link #add(Polinom, Polinom)},{@link #mul(Polinom, Polinom)},{@link #derivate(Polinom)},{@link #integrate(Polinom)},{@link #findValue(Polinom, int)}
 * 
 */
public class Operatii {

	int i = 0, j = 0;

	/**
	 * Method used to evaluate the sum of two polynomials
	 * 
	 * @param P
	 * @param Q
	 * @return Polinom P + Q
	 */
	public Polinom add(Polinom P, Polinom Q) {

		Monom m;
		// The returned polynomial
		Polinom PplusQ = new Polinom();

		int nrP = P.nrMonoms();
		int nrQ = Q.nrMonoms();

		try {
			while (i < nrP && j < nrQ) {
				// Coefficients and powers of P and Q
				double coefP = P.getMonom(i).getCoef();
				double coefQ = Q.getMonom(j).getCoef();
				double powerP = P.getMonom(i).getPower();
				double powerQ = Q.getMonom(j).getPower();

				if (powerP == powerQ) {
					m = new Monom(coefP + coefQ, powerP);
					i++;
					j++;
				}

				else if (powerP > powerQ) {
					m = new Monom(coefP, powerP);
					i++;
				} else {
					m = new Monom(coefQ, powerQ);
					j++;
				}
				PplusQ.addMonom(m);
			}
			while (i < nrP) {
				double coefP = P.getMonom(i).getCoef();
				double powerP = P.getMonom(i).getPower();
				m = new Monom(coefP, powerP);
				i++;
				PplusQ.addMonom(m);
			}
			while (j < nrQ) {
				double coefQ = Q.getMonom(j).getCoef();
				double powerQ = Q.getMonom(j).getPower();
				m = new Monom(coefQ, powerQ);
				j++;
				PplusQ.addMonom(m);
			}
		} catch (Exception E) {
		}
		;
		return PplusQ;
	}

	/**
	 * The method used to evaluate the difference between P and Q
	 * 
	 * @param P
	 * @param Q
	 * @return Polinom P - Q
	 */
	public Polinom sub(Polinom P, Polinom Q) {

		i = 0;
		j = 0;
		Monom m;
		Polinom PminusQ = new Polinom();
		int nrP = P.nrMonoms();
		int nrQ = Q.nrMonoms();
		try {
			while (i < nrP && j < nrQ) {

				double coefP = P.getMonom(i).getCoef();
				double coefQ = Q.getMonom(j).getCoef();
				double powerP = P.getMonom(i).getPower();
				double powerQ = Q.getMonom(j).getPower();

				if (powerP == powerQ) {
					m = new Monom(coefP - coefQ, powerP);
					i++;
					j++;
				} else if (powerP > powerQ) {
					m = new Monom(coefP, powerP);
					i++;
				} else {
					m = new Monom(-coefQ, powerQ);
					j++;
				}

				PminusQ.addMonom(m);
			}

			while (i < nrP) {
				double coefP = P.getMonom(i).getCoef();
				double powerP = P.getMonom(i).getPower();
				m = new Monom(coefP, powerP);
				i++;
				PminusQ.addMonom(m);
			}
			while (j < nrQ) {
				double coefQ = Q.getMonom(j).getCoef();
				double powerQ = Q.getMonom(j).getPower();
				m = new Monom(-coefQ, powerQ);
				j++;
				PminusQ.addMonom(m);
			}
		} catch (Exception E) {
		}
		;
		return PminusQ;
	}

	/**
	 * The method used to evaluate the multiplicity between P and Q
	 * 
	 * @param P
	 * @param Q
	 * @return Polinom P * Q
	 */
	public Polinom mul(Polinom P, Polinom Q) {
		int i = 0, j = 0;
		Monom m;
		Polinom PmulQ = new Polinom();

		try {
			int nrP = P.nrMonoms();
			int nrQ = Q.nrMonoms();

			while (i < nrP) {
				double coefP = P.getMonom(i).getCoef();
				double powerP = P.getMonom(i).getPower();
				i++;
				j = 0;

				while (j < nrQ) {
					double coefQ = Q.getMonom(j).getCoef();
					double powerQ = Q.getMonom(j).getPower();
					m = new Monom(coefP * coefQ, powerP + powerQ);
					PmulQ.addMonom(m);
					j++;
				}
			}

		} catch (Exception E) {
		}
		return PmulQ;
	}

	/**
	 * The method used to express the value of polynomial P in the point x
	 * 
	 * @author Adrian Muntean
	 * @param
	 * @return double P(x)
	 */
	public double findValue(Polinom P, int valx) {
		double val = 0;
		int i = 0;

		try {
			while (i < P.nrMonoms()) {
				val = (val + Math.pow(valx, P.getMonom(i).getPower()) * P.getMonom(i).getCoef());
				i++;
			}
		} catch (Exception E) {
		}
		;
		return val;
	}

	/**
	 * The method used to express the derivative of the polynomial P
	 * 
	 * @param P
	 * @return Polinom P(derivative)
	 */
	public Polinom derivate(Polinom P) {

		int i = 0;
		Polinom Pder = new Polinom();

		try {
			int nrP = P.nrMonoms();
			while (i < nrP) {
				double coefP = P.getMonom(i).getCoef();
				double powerP = P.getMonom(i).getPower();
				i++;

				if (powerP != 0) {
					Monom m = new Monom(coefP * powerP, powerP - 1);
					Pder.addMonom(m);
				}
			}
		} catch (Exception E) {
		}
		;
		return Pder;
	}

	/**
	 * The method used to evaluate the integrative value of polynomial P
	 * 
	 * @param P
	 * @return Polinom P(integrat)
	 */
	public Polinom integrate(Polinom P) {

		int i = 0;
		Polinom Pint = new Polinom();

		try {
			int nrP = P.nrMonoms();
			while (i < nrP) {
				double coefP = P.getMonom(i).getCoef();
				double powerP = P.getMonom(i).getPower();
				i++;

				Monom m = new Monom(coefP / (powerP + 1), powerP + 1);
				Pint.addMonom(m);
			}
		} catch (Exception E) {
		}
		;
		return Pint;
	}

	/**
	 * The mehtod used to express the value of P / Q
	 * 
	 * @param P
	 * @param Q
	 * @return String P / Q and the rest
	 */
	public String div(Polinom P, Polinom Q) {
		Operatii o = new Operatii();
		String div = "";
		Polinom PdivQ = new Polinom();
		String rest = "";
		try {
			while (P.getMonom(0).getPower() >= Q.getMonom(0).getPower()) {

				double coefQ = Q.getMonom(0).getCoef();
				double powerQ = Q.getMonom(0).getPower();

				Monom aux2 = new Monom(coefQ, powerQ);
				Monom aux3 = P.getMonom(i);
				double coefM = aux3.div(aux2).getCoef();
				double powerM = P.getMonom(i).div(aux2).getPower();

				Monom m = new Monom(coefM, powerM);
				Polinom aux = new Polinom();
				aux.addMonom(m);

				PdivQ.addMonom(m);

				Polinom p1 = new Polinom();
				p1 = o.mul(Q, aux);
				P = o.sub(P, p1);
				P.elimMonom(0);// }
			}
		} catch (Exception E) {
		}

		if (P.isEmpty())
			rest = "0";
		else
			rest = P.toStringDouble();
		div = PdivQ.toStringDouble() + " r = " + rest;

		return div;
	}

}
