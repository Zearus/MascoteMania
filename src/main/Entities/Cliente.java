package main.Entities;

import java.util.ArrayList;

public class Cliente {
    private String id;
    private String primeiroNome;
    private String ultimoNome;
    private ArrayList<Pedido> pedidos;

    public Cliente(String id, String primeiroNome, String ultimoNome, ArrayList<Pedido> pedidos) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.pedidos = pedidos;
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido); // Assume-se que pedidos é inicializado
    }

    public void removerPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
}
