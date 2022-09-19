package teste.basico;

import java.util.List;

import core.infra.DAO.ProdutoDAO;
import entity.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto("Monitor 32", 1789.99);
		
		List<Produto> produtos = dao.begin().incluir(produto).commit().findAll();
		produtos.stream().map(Produto::toString).forEach(System.out::println);
		
		dao.close();

	}

}
