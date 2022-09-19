package core.infra.DAO.muitosPraMuitos;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.muitosPraMuitos.Sobrinho;

public class SobrinhoDAO extends DAO<Sobrinho> {

	public SobrinhoDAO() {
		super(Sobrinho.class);
	}
	
	public void listarTodos() {
		List<Sobrinho> sobrinhos =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		sobrinhos.stream().map(Sobrinho::toString).forEach(System.out::println);
	}

}
