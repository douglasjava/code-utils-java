package com.example.demo.entendendo_algoritmos;

import java.util.LinkedList;

class TabelaHash {
    private static final int TAMANHO = 10;
    private LinkedList<Entrada>[] tabela;

    // Classe auxiliar para representar pares chave-valor
    private static class Entrada {
        Object chave;
        Object valor;

        public Entrada(Object chave, Object valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    public TabelaHash() {
        tabela = new LinkedList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int calcularHash(Object chave) {
        return Math.abs(chave.hashCode() % TAMANHO);
    }

    public void inserir(Object chave, Object valor) {
        int indice = calcularHash(chave);
        LinkedList<Entrada> lista = tabela[indice];

        // Verifica se a chave já existe na tabela
        for (Entrada entrada : lista) {
            if (entrada.chave.equals(chave)) {
                // Atualiza o valor se a chave já existe
                entrada.valor = valor;
                return;
            }
        }

        // Adiciona uma nova entrada se a chave não existe
        lista.add(new Entrada(chave, valor));
    }

    public Object buscar(Object chave) {
        int indice = calcularHash(chave);
        LinkedList<Entrada> lista = tabela[indice];

        // Procura a chave na lista
        for (Entrada entrada : lista) {
            if (entrada.chave.equals(chave)) {
                return entrada.valor;
            }
        }

        // Retorna null se a chave não for encontrada
        return null;
    }

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();

        tabelaHash.inserir("chave1", "valor1");
        tabelaHash.inserir("chave2", "valor2");
        tabelaHash.inserir("chave3", "valor3");

        System.out.println("Valor associado à chave1: " + tabelaHash.buscar("chave1"));
        System.out.println("Valor associado à chave2: " + tabelaHash.buscar("chave2"));
        System.out.println("Valor associado à chave3: " + tabelaHash.buscar("chave3"));
    }
}
