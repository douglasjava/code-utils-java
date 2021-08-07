package com.example.demo.threads;

public class MinhaThread2 implements Runnable {

	private String nome;
	private int tempo;

	public MinhaThread2(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}

	@Override
	public void run() {

		try {

			for (int i = 0; i < 6; i++) {
				System.out.println(this.nome + " contator: " + i + " Nome da thread: "
						+ Thread.currentThread().getName() + " Prioridade: " + Thread.currentThread().getPriority());
				Thread.sleep(tempo);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Fim da execução da Thread: " + nome);

	}

}
