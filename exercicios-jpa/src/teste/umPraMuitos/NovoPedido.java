package teste.umPraMuitos;

import core.infra.DAO.DAO;
import core.infra.DAO.ProdutoDAO;
import core.infra.DAO.umPraMuitos.ItemPedidoDAO;
import core.infra.DAO.umPraMuitos.PedidoDAO;
import entity.basico.Produto;
import entity.basico.umPraMuitos.ItemPedido;
import entity.basico.umPraMuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();
		ItemPedidoDAO itemPedidoDao = new ItemPedidoDAO();
		PedidoDAO pedidoDao = new PedidoDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Celular", 2900.89);
		ItemPedido item = new ItemPedido(pedido, produto, 10);
		
		dao.begin()
			.incluir(produto)
			.incluir(pedido)
			.incluir(item)
			.commit()
			.close();
		
		System.out.println("Produtos");
		produtoDao.listarTodos();
		
		System.out.println("\nPedidos");
		pedidoDao.listarTodos();
		
		System.out.println("\nItem Pedido");
		itemPedidoDao.listarTodos();
	}

}
