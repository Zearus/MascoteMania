package main.Control;

import main.Entities.Pedido;
import main.Entities.Cliente;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Mascote Mania.");

        boolean exec = true;

        while (exec) {
            System.out.println("01. Gerente\n02. Cliente\n03. Sair\n");
            System.out.print("Digite a opção desejada: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // int opcao_gerente = opcoesGerente();
                    // if (opcao_gerente == 1) {
                    //     GeraRelatorioControl geraRelatorioControl = new GeraRelatorioControl();
                    // } else if (opcao_gerente == 2) {
                    //     exec = false;
                    // } else {
                    //     System.out.println("Opção inválida.");
                    // }
                    break;
                case 2:
                    int opcao_cliente = opcoesCliente();
                    
                    if (opcao_cliente == 1) {
                        // RealizaCompraControl realizaCompraControl = new RealizaCompraControl();
                    } else if (opcao_cliente == 2) {
                        // AgendarServicoControl agendarServicoControl = new AgendarServicoControl();
                    } else if (opcao_cliente == 3) {
                        CancelarPedidoControl cancelaControl = new CancelarPedidoControl();
                    } else if (opcao_cliente == 4) {
                        exec = false;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    exec = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static int opcoesGerente() {
        System.out.println("01. Gerar Relatório\n 02. Sair\n");
        System.out.print("Digite a opção desejada: ");
        int opcaoGerente = scanner.nextInt();
        return opcaoGerente;
    }

    public static int opcoesCliente() {
        System.out.println("01. Realizar Compra\n02. Agendar Serviço\n03. Cancelar Pedido\n04. Sair\n");
        System.out.print("Digite a opção desejada: ");
        int opcaoCliente = scanner.nextInt();
        return opcaoCliente;
    }

    public static void popula() {
        Pedido pedido1 = new Pedido(1, "Ração", 2, 50.0, "Em andamento");
        Pedido pedido2 = new Pedido(2, "Brinquedo", 1, 30.0, "Entregue");
        Pedido pedido3 = new Pedido(3, "Cama", 1, 100.0, "Cancelado");

        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        Cliente cliente1 = new Cliente("1", "João", "Silva", pedidos);
        Cliente cliente2 = new Cliente("2", "Maria", "Santos", pedidos);
        Cliente cliente3 = new Cliente("3", "José", "Oliveira", pedidos);

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
    }
}
