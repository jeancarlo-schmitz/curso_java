package teste.consulta;

import java.util.List;

import core.infra.DAO.DAO;
import entity.basico.muitosPraMuitos.Ator;
import entity.basico.muitosPraMuitos.Filme;

public class ObterFilmes {

	public static void main(String[] args) {
		DAO<Filme>filmeDao = new DAO<>(Filme.class);
		
		List<Filme> filmes = filmeDao.consultar("obterfilmesComNotaMaiorQue", "nota", 8.1);
		
		for (Filme filme : filmes) {
			System.out.println(filme.getNome() + "=>" + filme.getNota());
			for (Ator atores : filme.getAtores()) {
				System.out.println(atores.getNome());
			}
		}
		
		
//		filmes.stream().map(Filme::toString).forEach(System.out::println);

	}

}
