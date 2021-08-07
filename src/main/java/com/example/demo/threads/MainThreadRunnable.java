package com.example.demo.threads;

public class MainThreadRunnable {

	public static void main(String[] args) {
		
		System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Nome: " + Thread.currentThread().getName());
        System.out.println("Prioridade: " + Thread.currentThread().getPriority());
        System.out.println("Estado: " + Thread.currentThread().getState());
		
		MinhaThreadRunnabled minhaThreadRunnabled = new MinhaThreadRunnabled("Thread #1", 900);
		
		MinhaThreadRunnabled minhaThreadRunnabled1 = new MinhaThreadRunnabled("Thread #2", 800);
		
		MinhaThreadRunnabled minhaThreadRunnabled2 = new MinhaThreadRunnabled("Thread #3", 1000);
		
	}
	
}
