package core.infra.DAO.umPraMuitos;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.umPraMuitos.ItemPedido;

public class ItemPedidoDAO extends DAO<ItemPedido>{

	public ItemPedidoDAO() {
		super(ItemPedido.class);
	}
	
	public void listarTodos() {
		List<ItemPedido> itensPedidos =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		itensPedidos.stream().map(ItemPedido::toString).forEach(System.out::println);
	}
}
