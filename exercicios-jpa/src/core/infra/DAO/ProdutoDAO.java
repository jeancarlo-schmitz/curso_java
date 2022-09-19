package core.infra.DAO;

import java.util.List;

import entity.basico.Produto;

public class ProdutoDAO extends DAO<Produto> {

	public ProdutoDAO() {
		super(Produto.class);
	}
	
	public void listarTodos() {
		List<Produto> produtos =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		produtos.stream().map(Produto::toString).forEach(System.out::println);
	}
}
