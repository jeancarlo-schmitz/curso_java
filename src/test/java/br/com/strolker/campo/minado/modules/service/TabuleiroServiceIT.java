package test.java.br.com.strolker.campo.minado.modules.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;
import main.java.br.com.strolker.campo.minado.modules.service.TabuleiroService;

class TabuleiroServiceIT {
	private CampoService campoService;
	private Tabuleiro tabuleiro;
	private TabuleiroService tabuleiroService;
	private List<Campo> todosCampos;
	
	@BeforeEach
	void inicializarCampoCentral() {
		campoService = new CampoService();
		tabuleiro = new Tabuleiro(6, 6, 6);
		tabuleiroService = new TabuleiroService();
		todosCampos = tabuleiro.getCampos();
	}
	
	@Test
	void verificaGerarCampos_ExpectQtdCamposCorreta() {
		Tabuleiro tabuleiroTeste = new Tabuleiro(6, 6, 6);
		assertEquals(tabuleiroTeste.getCampos().size(), 36);
	}
	
	@Test
	void verificaSortearMinas_ExpectQtdMinasCorreta() {
		assertEquals(this.quantidadeMinasTabuleiro(tabuleiro.getCampos()), 6);
	}
	
	@Test
	void isObjetivoJogoAlcancado_WithObjetivoAlcandadoTrue_ExpectTrue() {
		abrirTodosCamposTabuleiro(todosCampos);
		marcarTodosCamposMinados(todosCampos);
		assertTrue(tabuleiroService.isObjetivoJogoAlcancado(todosCampos));
	}
	
	@Test
	void isObjetivoJogoAlcancado_WithObjetivoAlcandadoFalse_ExpectFalse() {
		assertFalse(tabuleiroService.isObjetivoJogoAlcancado(todosCampos));
	}
	
	@Test
	void reiniciarTabuleiro_ExpectTabuleiroReiniciado() {
		this.isObjetivoJogoAlcancado_WithObjetivoAlcandadoTrue_ExpectTrue();
		
		tabuleiroService.reiniciarTabuleiro(6, todosCampos);
		assertFalse(tabuleiroService.isObjetivoJogoAlcancado(todosCampos));
	}
	
	private void abrirTodosCamposTabuleiro(List<Campo> campos) {
		campos.parallelStream()
			.filter(campo -> !campo.isMinado() && campo.isStatusCampoFechado())
			.forEach(campo -> campoService.abrirCampo(campo));
	}
	
	private void marcarTodosCamposMinados(List<Campo> campos) {
		campos.parallelStream()
			.filter(campo -> campo.isMinado() && campo.isStatusCampoFechado())
			.forEach(campo -> campoService.alterarMarcacao(campo));
	}
	
	private long quantidadeMinasTabuleiro(List<Campo> campos) {
		return campos.parallelStream().filter(campo -> campo.isMinado()).count();
	}
}
