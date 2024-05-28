// import Control.CancelarPedidoControl;
// import Entities.Cliente;
// import Entities.Estoque;
// import Entities.Pedido;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// public class CancelarPedidoControlTest {
//     private CancelarPedidoControl control;
//     private Cliente cliente;
//     private Estoque estoque;
//     private Pedido pedido;

//     @BeforeEach
//     public void setUp() {
//         control = new CancelarPedidoControl();
//         cliente = new Cliente("1", "senha1", "João", "Silva", pedidos);
//         estoque = new Estoque();
//         pedido = new Pedido(1, "Pendente", new Produto("Produto1"), 5);
//         cliente.getPedidos().add(pedido);
//     }

//     @Test
//     public void testCancelaPedidoPendente() {
//         int resultado = control.cancelaPedido(cliente, 1, estoque);
//         assertEquals(200, resultado);
//         assertEquals("Cancelado", pedido.getStatus());
//     }

//     @Test
//     public void testCancelaPedidoEntregue() {
//         pedido.setStatus("Entregue");
//         int resultado = control.cancelaPedido(cliente, 1, estoque);
//         assertEquals(400, resultado);
//     }

//     @Test
//     public void testCancelaPedidoEmTransporte() {
//         pedido.setStatus("Em Transporte");
//         int resultado = control.cancelaPedido(cliente, 1, estoque);
//         assertEquals(400, resultado);
//     }

//     @Test
//     public void testCancelaPedidoJaCancelado() {
//         pedido.setStatus("Cancelado");
//         int resultado = control.cancelaPedido(cliente, 1, estoque);
//         assertEquals(409, resultado);
//     }

//     @Test
//     public void testCancelaPedidoNaoEncontrado() {
//         int resultado = control.cancelaPedido(cliente, 999, estoque); // ID inexistente
//         assertEquals(404, resultado);
//     }
// }

