package teste.muitoPraMuitos;

import core.infra.DAO.DAO;
import entity.basico.muitosPraMuitos.Sobrinho;
import entity.basico.muitosPraMuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		Tio tia1 = new Tio("Maria");
		Tio tio2 = new Tio("João");
		
		Sobrinho sobrinho = new Sobrinho("Pedro");
		Sobrinho sobrinha = new Sobrinho("Ana");
		
		tia1.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tia1);
		
		tia1.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tia1);
		
		tio2.getSobrinhos().add(sobrinho);
		sobrinho.getTios().add(tio2);
		
		tio2.getSobrinhos().add(sobrinha);
		sobrinha.getTios().add(tio2);
		
		DAO<Object> dao = new DAO<>();
		
		dao.begin()
			.incluir(tia1)
			.incluir(tio2)
			.incluir(sobrinho)
			.incluir(sobrinha)
			.commit()
			.close();

	}

}
