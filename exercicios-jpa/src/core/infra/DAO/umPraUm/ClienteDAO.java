package core.infra.DAO.umPraUm;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.umPraUm.Cliente;

public class ClienteDAO  extends DAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}
	
	public void listarTodos() {
		List<Cliente> clientes =this.findAll();
		System.out.println("\n\nLista dos Produtos");
		clientes.stream().map(Cliente::toString).forEach(System.out::println);
	}


}
