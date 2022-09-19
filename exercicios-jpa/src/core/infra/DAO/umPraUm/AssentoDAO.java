package core.infra.DAO.umPraUm;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.umPraUm.Assento;

public class AssentoDAO extends DAO<Assento> {

	public AssentoDAO() {
		super(Assento.class);
	}
	
	public void listarTodos() {
		List<Assento> assentos =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		assentos.stream().map(Assento::toString).forEach(System.out::println);
	}

}
