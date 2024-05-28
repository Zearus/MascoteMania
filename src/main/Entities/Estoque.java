package Entities;

import java.util.HashMap;

public class Estoque {
    private HashMap<String, Integer> estoque;

    public Estoque() {
        estoque = new HashMap<>();
        estoque.put("Ração", 10);
        estoque.put("Brinquedo", 10);
        estoque.put("Remédio", 10);
        estoque.put("Cama", 10);
        estoque.put("Coleira", 10);
        estoque.put("Peitoral", 10);
    }

    public void adicionarProduto(String produto, int quantidade) {
        if (estoque.containsKey(produto)) {
            estoque.put(produto, estoque.get(produto) + quantidade);
        } else {
            estoque.put(produto, quantidade);
        }
    }


    public void removerProduto(String produto, int quantidade) {
        if (estoque.containsKey(produto)) {
            int quantidadeAtual = estoque.get(produto);
            if (quantidadeAtual > quantidade) {
                estoque.put(produto, quantidadeAtual - quantidade);
            } else {
                estoque.remove(produto);
            }
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
}
