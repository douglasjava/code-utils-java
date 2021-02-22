package com.example.demo.padraocodigo.strategyPattern;

/***
 * <b>Strategy Pattern</b>
 * <p>
 * Sendo categorizado com um padrão comportamental de desensenvolvimento de
 * software.
 * <p>
 * O Objetivo é representar uma operação a ser realizada sobre os elementos de
 * uma estrutura de objetos, esse padrão permite definir novas operações sem
 * alterar as classes dos elementos sobre os quais opera, permitindo que o
 * algoritmo varie independentemente dos clientes que o utilizam.
 * 
 * @author Marques
 *
 */
public abstract class Strategy {

	public abstract double calculate(double a, double b);

}
