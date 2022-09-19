package teste.umPraUm;

import core.infra.DAO.umPraUm.AssentoDAO;
import core.infra.DAO.umPraUm.ClienteDAO;
import entity.basico.umPraUm.Assento;
import entity.basico.umPraUm.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		ClienteDAO clienteDao = new ClienteDAO();
		AssentoDAO assentoDao = new AssentoDAO();
		
		Assento assento = new Assento("13W");
		Cliente cliente = new Cliente("Joaozinho", assento);
		
		assentoDao.begin().incluir(assento).commit().close();
		clienteDao.begin().incluir(cliente).commit().close();
		

	}

}
