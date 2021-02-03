package com.example.demo.andre;

public class Atividade6 {

	public static void main(String[] args) {
		Caminhao caminhao = new Caminhao();
		IVeiculo veiculo = caminhao;
		QuatroRodas fw = new Guindaste();
		//fw = veiculo;
		veiculo = fw;
	}

}
