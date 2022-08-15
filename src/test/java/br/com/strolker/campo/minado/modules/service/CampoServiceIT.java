package test.java.br.com.strolker.campo.minado.modules.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.domain.StatusCampo;
import main.java.br.com.strolker.campo.minado.modules.exception.ExplosaoException;
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

	@Test
	void alterarMarcacao_ExpectMarcadoTrue() {
		campoService.alterarMarcacao(central);
		assertTrue(central.isMarcado());
	}
	
	@Test
	void alterarMarcacao_CampoMarcadoTrue_ExpectMarcadoFalse() {
		Campo campo = inicializaCampoIsMarcadoTrue();
		assertTrue(campo.isMarcado());
		campoService.alterarMarcacao(campo);
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void abrirCampo_WithIsMarcadoFalseIsMinadoFalseAndStatusCampoFechado_ExpectAbrirCampoTrue() {
		boolean campoAberto = campoService.abrirCampo(central);
		assertTrue(campoAberto);
	}
	
	@Test
	void abrirCampo_WithIsMarcadoTrueAndStatusCampoFechado_ExpectAbrirCampoFalse() {
		Campo campo = inicializaCampoIsMarcadoTrue();
		assertTrue(campo.isMarcado());
		
		boolean campoAberto = campoService.abrirCampo(campo);
		assertFalse(campoAberto);
	}
	
	@Test
	void abrirCampo_WithIsMarcadoTrueIsMinadoTrueAndStatusCampoFechado_ExpectAbrirCampoFalse() {
		Campo campo = inicializaCampoIsMarcadoTrueIsMinadoTrue();
		assertTrue(campo.isMarcado());
		assertTrue(campo.isMinado());
		
		boolean campoAberto = campoService.abrirCampo(campo);
		assertFalse(campoAberto);
	}
	
	@Test
	void abrirCampo_WithIsMinadoTrueIsMarcadoFalseAndStatusCampoFechado_ExpectExplosaoException() {
		Campo campo = inicializaCampoIsMinadoTrue();
		assertFalse(campo.isMarcado());
		assertTrue(campo.isMinado());
		
		assertThrows(ExplosaoException.class, () -> {
			campoService.abrirCampo(campo);
		});
	}
	
	@Test
	void abrirCampo_WithStatusCampoAberto_ExpectAbrirCampoFalse() {
		Campo campo = inicializaCampoStatusCampoAberto();
		assertFalse(campo.isMarcado());
		assertFalse(campo.isMinado());
		assertTrue(campo.isStatusCampoAberto());
		
		boolean abrirCampo = campoService.abrirCampo(campo);
		
		assertFalse(abrirCampo);
	}
	
	@Test
	void abrirCampo_WithListVizinhosSeguros_ExpectAbrirCampoVzinhosTrue() {
		/*    V
 		 *  VV
		 *  C (2, 3)
		 */
		Campo vizinho1      = new Campo(1, 3);
		Campo vizinho2          = new Campo(1, 4);
		Campo vizinhoDoVizinho2 = new Campo(0, 5);

		Boolean resultadoInsercaoVizinho1 = campoService.adicionaVizinho(central, vizinho1);
		Boolean resultadoInsercaoVizinho2 = campoService.adicionaVizinho(central, vizinho2);
		Boolean resultadoInsercaoVizinhoDoVizinho2 = campoService.adicionaVizinho(vizinho2, vizinhoDoVizinho2);
		
		boolean isAllVizinho = Arrays.asList(
				resultadoInsercaoVizinho1, 
				resultadoInsercaoVizinho2,
				resultadoInsercaoVizinhoDoVizinho2).parallelStream().allMatch(result -> Boolean.TRUE.equals(result));

		assertTrue(isAllVizinho);
		
		campoService.abrirCampo(central);
		List<Campo> listCampos = new ArrayList<Campo>();
		listCampos.add(central);
		listCampos.add(vizinho1);
		listCampos.add(vizinho2);
		listCampos.add(vizinhoDoVizinho2);
		boolean isAllCamposAberto = listCampos.stream().allMatch(campo -> campo.isStatusCampoAberto());
		
		assertTrue(isAllCamposAberto);
	}
	
	@Test
	void abrirCampo_WithVizinhoSegurosEVizinhoMinado_ExpectAbrirCampoVzinhosSegurosENaoAbrirMinado() {
		/*    M
 		 *  VV
		 *  C (2, 3)
		 */
		Campo vizinho1      = new Campo(1, 3);
		Campo vizinho2          = new Campo(1, 4);
		Campo vizinhoDoVizinho2Minado = new Campo(0, 5);
		campoService.minarCampo(vizinhoDoVizinho2Minado);
		
		assertTrue(vizinhoDoVizinho2Minado.isMinado());

		Boolean resultadoInsercaoVizinho1 = campoService.adicionaVizinho(central, vizinho1);
		Boolean resultadoInsercaoVizinho2 = campoService.adicionaVizinho(central, vizinho2);
		Boolean resultadoInsercaoVizinhoDoVizinho2Minado = campoService.adicionaVizinho(vizinho2, vizinhoDoVizinho2Minado);
		
		boolean isAllVizinho = Arrays.asList(
				resultadoInsercaoVizinho1, 
				resultadoInsercaoVizinho2,
				resultadoInsercaoVizinhoDoVizinho2Minado).parallelStream().allMatch(result -> Boolean.TRUE.equals(result));

		assertTrue(isAllVizinho);

		campoService.abrirCampo(central);
		
		List<Campo> listCampos = new ArrayList<Campo>();
		listCampos.add(central);
		listCampos.add(vizinho1);
		listCampos.add(vizinho2);
		boolean isAllCamposAberto = listCampos.stream().allMatch(campo -> campo.isStatusCampoAberto());
		
		assertTrue(isAllCamposAberto);
		assertTrue(vizinhoDoVizinho2Minado.isStatusCampoFechado());
	}
	
	private Campo inicializaCampoIsMarcadoTrue() {
		Campo campo = new Campo(5, 8);
		campoService.alterarMarcacao(campo);
		return campo;
	}
	
	private Campo inicializaCampoIsMinadoTrue() {
		Campo campo = new Campo(5, 8);
		campoService.minarCampo(campo);
		return campo;
	}
	
	private Campo inicializaCampoStatusCampoAberto() {
		Campo campo = new Campo(5, 8);
		campoService.abrirCampo(campo);
		return campo;
	}
	
	private Campo inicializaCampoIsMarcadoTrueIsMinadoTrue() {
		Campo campo = new Campo(5, 8);
		campoService.alterarMarcacao(campo);
		campoService.minarCampo(campo);
		return campo;
	}
}
