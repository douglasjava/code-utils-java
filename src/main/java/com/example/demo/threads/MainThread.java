package com.example.demo.threads;

public class MainThread {

	public static void main(String[] args) {
		
		MinhaThread minhaThread = new MinhaThread("Thread #1", 200);
		
		
		MinhaThread minhaThread2 = new MinhaThread("Thread #2", 400);
		
		
		MinhaThread minhaThread3 = new MinhaThread("Thread #3", 900);
	}
	
}

