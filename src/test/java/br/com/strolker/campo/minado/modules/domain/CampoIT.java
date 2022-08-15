package test.java.br.com.strolker.campo.minado.modules.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;

class CampoIT {
	private Campo central;
	
	@BeforeEach
	void inicializarCampoCentral() {
		central = new Campo(2, 3); 
	}
	
	@Test
	void verificaValorPadrao_StatusCampo_ExpectStatusFechado() {
		assertTrue(central.isStatusCampoFechado());
	}
	
	@Test
	void verificaValorPadrao_CampoMarcado_ExpectMarcadoFalse() {
		assertFalse(central.isMarcado());
	}

}
