package test.java.br.com.strolker.campo.minado.modules.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;

class CampoServiceIT {
	
	private Campo central;
	private CampoService campoService;
	
	@BeforeEach
	void inicializarCampoCentral() {
		central = new Campo(2, 3); 
		campoService = new CampoService();
	}

	@Test
	void addManyVizinho_WithRealVizinhoPosition_ExpectSuccess() {
		/* VVV 
		   VCV
		   VVV */
		Campo vizinho1 = new Campo(1, 2);
		Campo vizinho2 = new Campo(2, 2);
		Campo vizinho3 = new Campo(3, 2);
		Campo vizinho4 = new Campo(1, 3);
		Campo vizinho5 = new Campo(3, 3);
		Campo vizinho6 = new Campo(1, 4);
		Campo vizinho7 = new Campo(2, 4);
		Campo vizinho8 = new Campo(3, 4); 

		Boolean resultadoInsercaoVizinho1 = campoService.adicionaVizinho(central, vizinho1);
		Boolean resultadoInsercaoVizinho2 = campoService.adicionaVizinho(central, vizinho2);
		Boolean resultadoInsercaoVizinho3 = campoService.adicionaVizinho(central, vizinho3);
		Boolean resultadoInsercaoVizinho4 = campoService.adicionaVizinho(central, vizinho4);
		Boolean resultadoInsercaoVizinho5 = campoService.adicionaVizinho(central, vizinho5);
		Boolean resultadoInsercaoVizinho6 = campoService.adicionaVizinho(central, vizinho6);
		Boolean resultadoInsercaoVizinho7 = campoService.adicionaVizinho(central, vizinho7);
		Boolean resultadoInsercaoVizinho8 = campoService.adicionaVizinho(central, vizinho8);
		
		boolean isAllVizinho = Arrays.asList(
				resultadoInsercaoVizinho1, 
				resultadoInsercaoVizinho2,
				resultadoInsercaoVizinho3,
				resultadoInsercaoVizinho4,
				resultadoInsercaoVizinho5,
				resultadoInsercaoVizinho6,
				resultadoInsercaoVizinho7,
				resultadoInsercaoVizinho8).parallelStream().allMatch(result -> Boolean.TRUE.equals(result));
		
		assertTrue(isAllVizinho);
		assertEquals(central.getVizinhanca().size(), 8);
	}
	

	@Test
	void addManyVizinho_WithFalseVizinhoPosition_ExpectFailure() {
		Campo vizinho1 = new Campo(0, 2);
		Campo vizinho2 = new Campo(2, 1);
		Campo vizinho3 = new Campo(4, 3);
		Campo vizinho4 = new Campo(1, 1);
		
		Boolean resultadoInsercaoVizinho1 = campoService.adicionaVizinho(central, vizinho1);
		Boolean resultadoInsercaoVizinho2 = campoService.adicionaVizinho(central, vizinho2);
		Boolean resultadoInsercaoVizinho3 = campoService.adicionaVizinho(central, vizinho3);
		Boolean resultadoInsercaoVizinho4 = campoService.adicionaVizinho(central, vizinho4);
		
		boolean isAllVizinho = Arrays.asList(
				resultadoInsercaoVizinho1, 
				resultadoInsercaoVizinho2,
				resultadoInsercaoVizinho3,
				resultadoInsercaoVizinho4).parallelStream().allMatch(result -> Boolean.FALSE.equals(result));
		
		assertTrue(isAllVizinho);
		assertEquals(central.getVizinhanca().size(), 0);
	}

}
