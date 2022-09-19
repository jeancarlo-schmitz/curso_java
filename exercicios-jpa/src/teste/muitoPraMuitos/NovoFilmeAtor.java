package teste.muitoPraMuitos;

import core.infra.DAO.DAO;
import entity.basico.muitosPraMuitos.Ator;
import entity.basico.muitosPraMuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		Filme filme1 = new Filme("Star Wars EP. 4", 8.7);
		Filme filme2 = new Filme("O Fugitivo", 8.9);
		Ator ator1 = new Ator("Harrison Ford");
		Ator ator2 = new Ator("Carrie Fisher");
		
		filme1.adicionarAtor(ator1);
		filme1.adicionarAtor(ator2);
		filme2.adicionarAtor(ator1);
		
		DAO<Filme> filmeDao = new DAO<>();
		filmeDao.incluirAtomico(filme1);
	}
}
