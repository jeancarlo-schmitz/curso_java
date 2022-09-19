package teste.basico;


import core.infra.DAO.ProdutoDAO;

public class ObterProdutos {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();

		dao.listarTodos();
		dao.close();
	}
}
