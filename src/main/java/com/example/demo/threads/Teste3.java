package com.example.demo.threads;

//t1.join(200); /// A thread 2 só vai começar a execução quando a t1 acabar ou passar 200ms
public class Teste3 {

	public static void main(String[] args) throws InterruptedException {

		MinhaThread2 minhaThreadRunnabled = new MinhaThread2("Thread #1", 200);
		MinhaThread2 minhaThreadRunnabled1 = new MinhaThread2("Thread #2", 800);
		MinhaThread2 minhaThreadRunnabled2 = new MinhaThread2("Thread #3", 700);

		Thread t1 = new Thread(minhaThreadRunnabled);
		Thread t2 = new Thread(minhaThreadRunnabled1);
		Thread t3 = new Thread(minhaThreadRunnabled2);

		t1.start();
		t2.start();
		t3.start();

		t1.join(200);
		t2.join(200);
		t3.join(200);

		System.out.println("Programa finalizado.");
	}

}
