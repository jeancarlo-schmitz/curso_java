package core.infra.DAO.umPraMuitos;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.umPraMuitos.Pedido;

public class PedidoDAO extends DAO<Pedido> {

	public PedidoDAO() {
		super(Pedido.class);
	}
	
	public void listarTodos() {
		List<Pedido> pedidos =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		pedidos.stream().map(Pedido::toString).forEach(System.out::println);
	}

}
