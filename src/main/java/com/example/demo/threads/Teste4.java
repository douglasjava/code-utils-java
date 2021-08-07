package com.example.demo.threads;

public class Teste4 {

	public static void main(String[] args) {
		
		MinhaThread2 thread1 = new MinhaThread2("#1", 500);
		MinhaThread2 thread2 = new MinhaThread2("#2", 500);
		MinhaThread2 thread3 = new MinhaThread2("#3", 500);
		
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);
		
		//t1.setPriority(2);
		//t2.setPriority(3);
		//t3.setPriority(1);
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
