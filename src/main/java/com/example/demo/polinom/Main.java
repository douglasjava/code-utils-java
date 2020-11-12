package com.example.demo.polinom;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Adrian Muntean Main class - which is the GUI class. The program is a
 *         polynomials calculator.It does the basic sum,substract ,multiply,
 *         divide integrate, derivative and finding the value into a point.
 * @see: {@link Main#addComponentsToPane(Container)}
 *       {@link Main#createAndShowGUI()}
 *       {@link Main#actionPerformed(ActionEvent)}
 */
public class Main implements ActionListener {
	private String work = ""; // The String in which we will place the final value
	private static Polinom polinomP = new Polinom();
	private static Polinom polinomQ = new Polinom();
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;// Orientation
	private boolean readP = true, readQ = true;// Used to read the polynomials
	/**
	 * Binay operations buttons
	 */
	JButton add, sub, mul, div;
	/**
	 * unary operations buttons
	 */
	JButton der, integrate, findValue;
	/**
	 * Instruction pop up button. When pressed a pop up appears with the program
	 * instructions.
	 */
	JButton instr;
	/**
	 * Reset button. Operations are made on the same polynomials until reset button
	 * is pressed.
	 */
	JButton reset;
	/**
	 * Text fields used to enter the two polynomials and display the result.
	 */
	JTextField editarePolinomP, editarePolinomQ, resultTextField;
	/**
	 * Labels for Text Fields
	 */
	JLabel poliP, poliQ, result;
	/**
	 * Radio buttons to choose between the operations. If the binary button is
	 * selected then the unary operations are made unavailable and vice - versa.
	 */
	JRadioButton binary, unary;
	GridBagConstraints c = new GridBagConstraints();// The constraints

	/**
	 * The method which adds the component to the container.
	 * 
	 * @author Adrian Muntean
	 * @param pane
	 */
	public void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		pane.setLayout(new GridBagLayout()); // Layout form

		// Instantiate and place the radio buttons
		binary = new JRadioButton("Operatii binare");
		c.gridx = 0;
		c.gridy = 0;
		binary.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Used to make unavailable the unary buttons
				add.setEnabled(true);
				sub.setEnabled(true);
				mul.setEnabled(true);
				div.setEnabled(true);
				editarePolinomQ.setEnabled(true);
				der.setEnabled(false);
				integrate.setEnabled(false);
				findValue.setEnabled(false);
				polinomQ.reset();
				readQ = true;
			}

		});
		binary.setSelected(true);
		pane.add(binary, c);

		unary = new JRadioButton("Operatii unare");
		c.gridx++;
		unary.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Used to make unavailable the binary buttons
				add.setEnabled(false);
				sub.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				editarePolinomQ.setEnabled(false);
				editarePolinomQ.setText(null);
				resultTextField.setText(null);
				// enable unary actions
				der.setEnabled(true);
				integrate.setEnabled(true);
				findValue.setEnabled(true);

			}

		});
		pane.add(unary, c);

		// We group the radio buttons
		ButtonGroup grup = new ButtonGroup();
		grup.add(unary);
		grup.add(binary);

		// Instantiate and place the 'P' label
		poliP = new JLabel("Polinomul P :", JLabel.LEFT);
		c.gridx = 0;
		c.gridy = 1;
		pane.add(poliP, c);

		// Instantiate and place the first text field
		editarePolinomP = new JTextField(10);
		editarePolinomP.setActionCommand("Ceva text");
		c.gridx++;
		pane.add(editarePolinomP, c);
		poliQ = new JLabel("Polinomul Q :", JLabel.LEFT);
		c.gridx = 0;
		c.gridy = 2;
		pane.add(poliQ, c);

		// Instantiate and place the second text field
		editarePolinomQ = new JTextField(10);
		c.gridx++;
		pane.add(editarePolinomQ, c);

		// Leave some space between the elements
		pane.add(Box.createRigidArea(new Dimension(50, 0)));

		// Instantiate and place the add button
		add = new JButton("+");
		c.gridx = 3;
		c.gridy = 1;
		pane.add(add, c);
		add.addActionListener(this);

		// Instantiate and place the substract button
		sub = new JButton("-");
		c.gridx++;
		sub.addActionListener(this);
		pane.add(sub, c);

		// Instantiate and place the multiply button
		mul = new JButton("*");
		c.gridx++;
		mul.addActionListener(this);
		pane.add(mul, c);

		// Instantiate and place the divide button
		div = new JButton("/");
		div.addActionListener(this);
		c.gridx++;
		pane.add(div, c);

		// Instantiate and place the derivative button
		der = new JButton("\u03B4");
		c.gridy = 2;
		c.gridx = 3;
		der.addActionListener(this);
		pane.add(der, c);

		// Instantiate and place the integrate button
		integrate = new JButton("\u0283");
		c.gridx++;
		integrate.addActionListener(this);
		pane.add(integrate, c);

		// Instantiate and place the 'find value' button
		findValue = new JButton("P(x)");
		findValue.setMargin(new Insets(2, 2, 2, 5));
		findValue.addActionListener(this);
		c.gridx++;
		pane.add(findValue, c);

		// Instantiate and place the 'result' label
		result = new JLabel("Rezultat :", JLabel.LEFT);
		c.gridx = 0;
		c.gridy = 3;
		pane.add(result, c);
		result.setFont(result.getFont().deriveFont(18.0f));

		// Instantiate and place the result text field
		resultTextField = new JTextField(20);
		c.gridx++;
		c.ipadx = 15;
		c.ipady = 10;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		resultTextField.setEditable(false);
		resultTextField.setBackground(new Color(180, 190, 210));
		pane.add(resultTextField, c);
		c.gridx = 0;
		c.gridy = 0;
		// Leave some space bewteen the elements
		pane.add(Box.createRigidArea(new Dimension(50, 0)));

		// Instantiate and place the instruction button
		instr = new JButton("Instructiuni");
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.gridy = 3;
		c.gridx = 7;
		c.ipadx = 1;
		c.ipady = 1;
		instr.addActionListener(this);
		pane.add(instr, c);
		instr.setFont(instr.getFont().deriveFont(9.0f));

		// Instantiate and place the reset button
		reset = new JButton("C");
		reset.addActionListener(this);
		reset.setFont(reset.getFont().deriveFont(9.0f));
		c.gridy = 3;
		c.gridx = 6;
		c.ipadx = 1;
		c.ipady = 1;
		pane.add(reset, c);

		// Disable the unary operations because by default the "Operatii binare" is
		// selected
		der.setEnabled(false);
		integrate.setEnabled(false);
		findValue.setEnabled(false);
	}

	/**
	 * The method which intercepts the events
	 * 
	 * @param ev
	 */
	public void actionPerformed(ActionEvent ev) {
		String textP, textQ;// used to read the polynomials
		/**
		 * The coefficient of the monoms cMonom = the coefficient of the monom iMonom =
		 * the power of the monom
		 */
		int cMonom = 0, iMonom = 0;
		int valx;// used to read the value of the desired point
		boolean hasCoef = false; // used to determine if P or Q starts with a coefficient
		boolean negative = false;//
		String inter = ""; // intermediate value used in reading process for P
		String interQ = "";// intermediate value used in reading process for Q
		// Instantiate the operations object
		Operatii o = new Operatii();

		final String mesajFormat = "Format invalid.\nVerificati instructiunile pentru detalii";
		final String mesajGrad = "Gradul polinomului P este mai mic decat gradul polinomului Q";
		final String mesajInstructiuni = "Se selecteaza tipul de operatii dorite(unare sau binare) apoi se  introduc(e) polinoamele(ul).Formatul polinoamelor este \n\n    a(n)x^b(n)+a(n-1)x^b(n-1)+...+a(0)\nunde a(n) si b(n) sunt coeficientii, respectiv puterea.\n\n "
				+ "Apoi din meniul din dreapta se selecteaza operatia dorita.Pentru a introduce noi valori se apasa butonul 'C',acesta va duce la resetarea campurilor.\n"
				+ "Pentru mai multe detalii consultati manualul.";
		// Getting the polynomial P
		if (readP) {
			textP = editarePolinomP.getText();// get the text from the text field
			if (textP.startsWith("-")) {
				hasCoef = true;
				negative = true;
			}
			if (textP.startsWith("x")) {
				hasCoef = true;
				negative = false;
			}
			if (hasCoef == true) {

				if (negative == true) {
					cMonom = -1;
					textP = textP.substring(1);
				}
				if (negative == false)
					cMonom = 1;

			}
			// the token used to break into integers was "x^"
			StringTokenizer st1 = new StringTokenizer(textP, "x^");

			while (st1.hasMoreElements()) {

				inter = (String) st1.nextElement();

				// Forward dividing into integers
				StringTokenizer st2 = new StringTokenizer(inter, "+");
				StringTokenizer st3 = new StringTokenizer(inter, "-");

				if (inter.indexOf("-") != -1) // if it has a - operator then we use
					while (st3.hasMoreElements()) {// this part of code to break the string
						try {
							if (cMonom == 0) {
								String copy = (String) st3.nextElement();
								cMonom = Integer.parseInt(copy);
								cMonom = -cMonom;
								continue;
							}

							else if (iMonom == 0) {
								String copy = (String) st3.nextElement();
								iMonom = Integer.parseInt(copy);
								continue;
							}
						}
						// NumberFormatException could be thrown
						catch (Exception e) {
							popUp(mesajFormat);
						}
						// We add the monom to the polynom
						Monom monom = new Monom(cMonom, iMonom);
						polinomP.addMonom(monom);
						iMonom = 0;
						cMonom = 0;
					}
				else // it doesn't containt '-'
					while (st2.hasMoreElements()) {

						if (cMonom == 0) {
							String value = (String) st2.nextElement();
							try {
								cMonom = Integer.parseInt(value);
							} catch (Exception e) {
								popUp(mesajFormat);
							}
							continue;
						}

						else if (iMonom == 0) {
							String value = (String) st2.nextElement();
							try {
								iMonom = Integer.parseInt(value);
							} catch (Exception e) {
								popUp(mesajFormat);
							}

							continue;
						}
						// Instantiate and add the monom to P
						Monom monom = new Monom(cMonom, iMonom);
						polinomP.addMonom(monom);
						// reseting the values
						iMonom = 0;
						cMonom = 0;
					}

			}
			if (cMonom != 0) {

				Monom monom = new Monom(cMonom, iMonom);
				polinomP.addMonom(monom);

			}
			readP = false;// We read P only once until reset button is pressed
		}

		// Getting the polynom Q
		if (binary.isSelected() && readQ) {
			textQ = editarePolinomQ.getText();
			// reset the values
			iMonom = 0;
			cMonom = 0;
			hasCoef = false;
			negative = false;

			if (textQ.startsWith("-")) {
				hasCoef = true;
				negative = true;
			}
			if (textQ.startsWith("x")) {
				hasCoef = true;
				negative = false;
			}

			if (hasCoef == true) {

				if (negative == true) {
					cMonom = -1;
					textQ = textQ.substring(1);
				}
				if (negative == false)
					cMonom = 1;

			}

			StringTokenizer stQ1 = new StringTokenizer(textQ, "x^");

			while (stQ1.hasMoreElements()) {

				interQ = (String) stQ1.nextElement();

				StringTokenizer stQ2 = new StringTokenizer(interQ, "+");
				StringTokenizer stQ3 = new StringTokenizer(interQ, "-");

				if (interQ.indexOf("-") != -1) // if it has a - operator then we use
					while (stQ3.hasMoreElements()) {// this part of code to break the string

						try {
							if (cMonom == 0) {
								String copy = (String) stQ3.nextElement();
								cMonom = Integer.parseInt(copy);
								cMonom = -cMonom;
								continue;
							}

							else if (iMonom == 0) {
								String copy = (String) stQ3.nextElement();
								iMonom = Integer.parseInt(copy);

								continue;
							}
						} catch (Exception e) {
							popUp(mesajFormat);
						}

						// Instantiate and add the monom to the polynomial
						Monom monom = new Monom(cMonom, iMonom);
						polinomQ.addMonom(monom);
						// reset the values
						iMonom = 0;
						cMonom = 0;
					}
				else
					while (stQ2.hasMoreElements()) {// It has '+' as a token

						if (cMonom == 0) {
							String value = (String) stQ2.nextElement();
							try {
								cMonom = Integer.parseInt(value);
							} catch (Exception e) {
								popUp(mesajFormat);
							}
							continue;
						}

						else if (iMonom == 0) {
							String value = (String) stQ2.nextElement();
							try {
								iMonom = Integer.parseInt(value);
							} catch (Exception e) {
								popUp(mesajFormat);
							}
							continue;
						}
						// Instantiate and add the monom to the polynomial
						Monom monom = new Monom(cMonom, iMonom);
						System.out.println("Creat monomul :" + cMonom + " , " + iMonom);
						polinomQ.addMonom(monom);
						iMonom = 0;
						cMonom = 0;
					}
				// A test display to see if the reading is done properly
				System.out.println("Polinomul P dupa citire " + polinomP.toString());
				System.out.println("Polinomul Q dupa citire " + polinomQ.toString());

			}

			if (cMonom != 0) {
				Monom monom = new Monom(cMonom, iMonom);
				polinomQ.addMonom(monom);
			}

			readQ = false;// We read only once until the pressing of reset button
		}

		// Actions to happen if the properly buttons are pressed
		if (ev.getSource() == der) {
			// Derivate
			work = o.derivate(polinomP).toString();
		}

		if (ev.getSource() == integrate) {
			// Integrate
			work = o.integrate(polinomP).toStringDouble();
		}

		if (ev.getSource() == reset) {
			// Reset all the fields
			readP = true;
			readQ = true;
			editarePolinomQ.setText("");
			editarePolinomP.setText("");
			work = "";
			polinomP.reset();
			polinomQ.reset();
		}

		if (ev.getSource() == sub) {
			// Substract
			work = o.sub(polinomP, polinomQ).toString();
		}

		if (ev.getSource() == add) {
			// Add
			work = o.add(polinomP, polinomQ).toString();
		}

		if (ev.getSource() == mul) {

			// Multiply
			work = o.mul(polinomP, polinomQ).toString();
		}

		if (ev.getSource() == findValue) {
			// Find value
			try {
				valx = Integer.parseInt(JOptionPane.showInputDialog(findValue, "Introduceti valoarea dorita", null));
				work = o.findValue(polinomP, valx) + "";
			} catch (NumberFormatException E) {
				popUp(mesajFormat);
			}
		}

		if (ev.getSource() == instr) {
			// Instruction button
			JOptionPane.showMessageDialog(instr, mesajInstructiuni, "Instructiuni", JOptionPane.PLAIN_MESSAGE // Message
																												// option
			);
		}

		if (ev.getSource() == div) {
			// division
			if (polinomP.getMonom(0).getPower() < polinomQ.getMonom(0).getPower()) {
				popUp(mesajGrad);
				work = "0  " + "r = " + polinomP.toString();
			}

			else
				work = o.div(polinomP, polinomQ);
		}

		// Setting the result text field
		resultTextField.setText(work);
	}

	/**
	 * Method used to display a popUp windows. This is used to show errors and
	 * instructions.
	 * 
	 * @author Adrian Muntean
	 */
	private void popUp(String mesaj) {

		JOptionPane.showMessageDialog(null, mesaj, "Eroare", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * The method which create and shows the GUI.
	 * 
	 * @author Adrian Muntean
	 */
	private void createAndShowGUI() {

		// Create and set up the window.
		JFrame frame = new JFrame("Calcul de polinom");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Main obj = new Main();// type Main object
		obj.createAndShowGUI();// call to create method
	}
}