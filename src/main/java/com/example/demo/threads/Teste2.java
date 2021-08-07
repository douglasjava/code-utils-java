package com.example.demo.threads;

public class Teste2 {

	public static void main(String[] args) {

		MinhaThread2 minhaThreadRunnabled = new MinhaThread2("Thread #1", 500);
		MinhaThread2 minhaThreadRunnabled1 = new MinhaThread2("Thread #2", 500);
		MinhaThread2 minhaThreadRunnabled2 = new MinhaThread2("Thread #3", 500);

		Thread t1 = new Thread(minhaThreadRunnabled);
		Thread t2 = new Thread(minhaThreadRunnabled1);
		Thread t3 = new Thread(minhaThreadRunnabled2);

		t1.start();
		t2.start();
		t3.start();

		while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Programa finalizado.");
	}

}
