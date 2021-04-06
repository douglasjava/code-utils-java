package com.example.demo.javaefetivo.capitulo2.item2;

import com.example.demo.javaefetivo.capitulo2.item2.NyPizza.Size;
import com.example.demo.javaefetivo.capitulo2.item2.Pizza.Topping;

public class MainBuilder {

	public static void main(String[] args) {
		
		NyPizza pizza = (NyPizza) new NyPizza.Builder(Size.SMALL)
					.addTopping(Topping.SAUSAGE)
					.addTopping(Topping.ONION)
					.build();
		
		Calzone calzone = (Calzone) new Calzone.Builder()
					.addTopping(Topping.HAM)
					.sauceInside().build();
		
		System.out.println(pizza);
		
		System.out.println("---------------");
		
		System.out.println(calzone);
		
	}
	
}
