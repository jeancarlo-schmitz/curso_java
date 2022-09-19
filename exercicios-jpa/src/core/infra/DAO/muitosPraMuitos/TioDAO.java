package core.infra.DAO.muitosPraMuitos;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.muitosPraMuitos.Tio;

public class TioDAO extends DAO<Tio> {

	public TioDAO() {
		super(Tio.class);
	}
	
	public void listarTodos() {
		List<Tio> tios =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		tios.stream().map(Tio::toString).forEach(System.out::println);
	}

}
