package teste.consulta;

import core.infra.DAO.DAO;
import entity.basico.consulta.NotaFilme;

public class ObterMediaFilmes {

	public static void main(String[] args) {
		DAO<NotaFilme>notaFilmeDao = new DAO<>(NotaFilme.class);
		
		NotaFilme notaFilme = notaFilmeDao.consultarUm("obterMediaGeralDosFilmes");
		System.out.println(notaFilme.getMedia());
		
		notaFilmeDao.close();

	}

}
