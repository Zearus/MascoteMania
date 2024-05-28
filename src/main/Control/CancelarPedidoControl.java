package Control;

import Entities.Cliente;
import Boundary.CancelarPedidoBoundary;

public class CancelarPedidoControl {
    public CancelarPedidoControl() {
        // cancelarPedido(Cliente cliente);
    }

    public void cancelarPedido(Cliente cliente) {
        CancelarPedidoBoundary cancelarPedidoBoundary = new CancelarPedidoBoundary();
        cancelarPedidoBoundary.cancelarPedido(cliente, Main.scanner);
    }

    public int cancelaPedido(Cliente cliente, int idPedido) {
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            if (cliente.getPedidos().get(i).getId() == idPedido) {
                if (cliente.getPedidos().get(i).getStatus().equals("Entregue")) {
                    return 400;
                } else if (cliente.getPedidos().get(i).getStatus().equals("Em Transporte")) {
                    return 400;
                }
                
                cliente.getPedidos().remove(i);
                return 200;
            }
        }
        return 404;
    }
}

        // for (int i = 0; i < cliente.getPedidos().size(); i++) {
        //     if (cliente.getPedidos().get(i).getId() == id) {
        //         if (cliente.getPedidos().get(i).getStatus().equals("Entregue")) {
        //             System.out.println("Pedido já entregue, não pode ser cancelado.");
        //             break;
        //         } else if (cliente.getPedidos().get(i).getStatus().equals("Em Transporte")) {
        //             System.out.println("Pedido em transporte, não pode ser cancelado.");
        //             break;
        //         }
                
        //         cliente.getPedidos().remove(i);
        //         System.out.println("Pedido cancelado.");
        //         break;
        //     }
        //     else {
        //         System.out.println("Pedido não encontrado.");
        //     }
        // }