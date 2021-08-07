package com.example.demo.threads;

public class MinhaThread extends Thread {

	private String nome;
	private int tempo;

	public MinhaThread(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		start();
	}

	@Override
	public void run() {

		try {

			for (int i = 0; i < 6; i++) {
				System.out.println(this.nome + " contator: " + i);
				Thread.sleep(tempo);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fim da execução da Thread: "+ nome);

	}

}
