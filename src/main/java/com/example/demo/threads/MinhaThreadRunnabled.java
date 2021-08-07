package com.example.demo.threads;

public class MinhaThreadRunnabled implements Runnable {

	private String nome;
	private int tempo;

	public MinhaThreadRunnabled(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		new Thread(this).start();
	}

	@Override
	public void run() {

		try {

			for (int i = 0; i < 6; i++) {
				System.out.println(this.nome + " contator: " + i + " Nome da thread: " + Thread.currentThread().getName() +  " Prioridade: " + Thread.currentThread().getPriority());
				Thread.sleep(tempo);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Fim da execução da Thread: " + nome);

	}

}
