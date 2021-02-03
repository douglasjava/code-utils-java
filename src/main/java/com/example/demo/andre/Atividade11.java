package com.example.demo.andre;

public class Atividade11 {

	public int x(int x) {
		if(x== 0) {
			return 1;
		}
		return x * x (x-1);
	}
	
	public static void main(String[] args) {
		Atividade11 xAtividade11 = new Atividade11();		
		System.out.println(xAtividade11.x(5));
	}
	
}
