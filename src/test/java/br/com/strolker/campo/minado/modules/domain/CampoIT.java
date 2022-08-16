package test.java.br.com.strolker.campo.minado.modules.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;

class CampoIT {
	private Campo central;
	private CampoService campoService;
	
	@BeforeEach
	void inicializarCampoCentral() {
		central = new Campo(2, 3); 
		campoService = new CampoService();
	}
	
	@Test
	void verificaValorPadrao_StatusCampo_ExpectStatusFechado() {
		assertTrue(central.isStatusCampoFechado());
	}
	
	@Test
	void verificaValorPadrao_CampoMarcado_ExpectMarcadoFalse() {
		assertFalse(central.isMarcado());
	}
	
	@Test
	void toString_WithOutModify_ExpectCorrectCharactere() {
		assertEquals(central.toString(), "?");
	}
	
	@Test
	void toString_WithStatusCampoMarcado_ExpectCorrectCharactere() {
		central.setMarcado(true);
		assertEquals(central.toString(), "x");
	}
	
	@Test
	void toString_WithStatusCampoMinadoAberto_ExpectCorrectCharactere() {
		central.setMinado(true);
		central.setStatusCampoAberto();
		assertEquals(central.toString(), "*");
	}
	
	@Test
	void toString_WithVizinhosMinados_ExpectCorrectCharactere() {
		inicializaCampoCentralComVizinhosMinados(2, 4);
		assertEquals(central.getVizinhanca().size(), 1);
		
		inicializaCampoCentralComVizinhosMinados(2, 2);
		assertEquals(central.getVizinhanca().size(), 2);
		
		inicializaCampoCentralComVizinhosMinados(1, 3);
		assertEquals(central.getVizinhanca().size(), 3);
		
		campoService.abrirCampo(central);
		assertEquals(central.toString(), "3");
	}

	private void inicializaCampoCentralComVizinhosMinados(int linha, int coluna) {
		Campo vizinhoMinado = inicializaCampoIsMinadoTrue(linha, coluna);
		assertTrue(vizinhoMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoMinado);
	}
	
	private Campo inicializaCampoIsMinadoTrue(int linha, int coluna) {
		Campo campo = new Campo(linha, coluna);
		campoService.minarCampo(campo);
		return campo;
	}

}
