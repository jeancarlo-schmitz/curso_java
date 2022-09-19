package teste.umPraMuitos;

import core.infra.DAO.umPraMuitos.PedidoDAO;
import entity.basico.umPraMuitos.ItemPedido;
import entity.basico.umPraMuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		PedidoDAO pedidoDao = new PedidoDAO();
		
		Pedido pedido = pedidoDao.findById(1L);

		pedido.getItens().stream().map(ItemPedido::toString).forEach(System.out::println);
	}

}
