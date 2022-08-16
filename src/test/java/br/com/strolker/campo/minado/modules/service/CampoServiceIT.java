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
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.exception.ExplosaoException;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;

class CampoServiceIT {
	
	private Campo central;
	private CampoService campoService;
	private Tabuleiro tabuleiro;
	
	@BeforeEach
	void inicializarCampoCentral() {
		central = new Campo(2, 3); 
		campoService = new CampoService();
		tabuleiro = new Tabuleiro(6, 6, 6);
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
	
	@Test
	void isObjetivoCampoAlcancado_WithStatusCampoAberto_ExpectTrue(){
		Campo campo = inicializaCampoStatusCampoAberto();
		assertTrue(campoService.isObjetivoCampoAlcancado(campo));
	}
	
	@Test
	void isObjetivoCampoAlcancado_WithStatusCampoFechado_ExpectFalse(){
		assertTrue(central.isStatusCampoFechado());
		assertFalse(campoService.isObjetivoCampoAlcancado(central));
	}
	
	@Test
	void isObjetivoCampoAlcancado_WithStatusCampoAbertoEMinadoTrue_ExpectFalse(){
		Campo campo = inicializaCampoIsMinadoTrue();
		campo.setStatusCampoAberto();
		assertTrue(campo.isStatusCampoAberto());
		assertTrue(campo.isMinado());
		assertFalse(campoService.isObjetivoCampoAlcancado(campo));
	}
	
	@Test
	void isObjetivoCampoAlcancado_WithCampoMinadoEMarcadoTrue_ExpectTrue(){
		Campo campo = inicializaCampoIsMarcadoTrueIsMinadoTrue();
		assertTrue(campo.isMarcado());
		assertTrue(campo.isMinado());
		
		assertTrue(campoService.isObjetivoCampoAlcancado(campo));
	}
	
	@Test
	void isObjetivoCampoAlcancado_WithCampoMinadoTrueEMarcadoFalse_ExpectFalse(){
		Campo campo = inicializaCampoIsMinadoTrue();
		assertFalse(campo.isMarcado());
		assertTrue(campo.isMinado());
		
		assertFalse(campoService.isObjetivoCampoAlcancado(campo));
	}
	
	@Test
	void reiniciarCampo_WithStatusCampoAberto_ExpectStatusCampoFechado(){
		Campo campo = inicializaCampoStatusCampoAberto();
		assertTrue(campo.isStatusCampoAberto());

		campoService.reiniciarCampo(campo);
		assertTrue(campo.isStatusCampoFechado());
	}
	
	@Test
	void reiniciarCampo_WithCampoMinadoTrue_ExpectCampoMinadoFalse(){
		Campo campo = inicializaCampoIsMinadoTrue();
		assertTrue(campo.isMinado());

		campoService.reiniciarCampo(campo);
		assertFalse(campo.isMinado());
	}
	
	@Test
	void reiniciarCampo_WithCampoMarcadoTrue_ExpectCampoMarcadoFalse(){
		Campo campo = inicializaCampoIsMarcadoTrue();
		assertTrue(campo.isMarcado());

		campoService.reiniciarCampo(campo);
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void reiniciarCampo_WithCampoMinadoEMarcadoTrue_ExpectCampoMinadoEMarcadoFalse(){
		Campo campo = inicializaCampoIsMarcadoTrueIsMinadoTrue();
		assertTrue(campo.isMinado());
		assertTrue(campo.isMarcado());

		campoService.reiniciarCampo(campo);
		assertFalse(campo.isMinado());
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void getQtdMinasVizinhanca_WithUmVizinhoMinado_ExpectResultUm(){
		/*C(2, 3*/
		
		/*CM*/
		Campo vizinhoDireitaMinado = inicializaCampoIsMinadoTrue(2, 4);
		assertTrue(vizinhoDireitaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDireitaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoDireitaMinado);
		
		/*MC*/
		Campo vizinhoEsquerdaMinado = inicializaCampoIsMinadoTrue(2, 2);
		assertTrue(vizinhoEsquerdaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoEsquerdaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoEsquerdaMinado);
		
		/* M
		 * C*/
		Campo vizinhoCimaMinado = inicializaCampoIsMinadoTrue(1, 3);
		assertTrue(vizinhoCimaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoCimaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoCimaMinado);
		
		/* C
		 * M*/
		Campo vizinhoBaixoMinado = inicializaCampoIsMinadoTrue(3, 3);
		assertTrue(vizinhoBaixoMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoBaixoMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoBaixoMinado);
		
		/*M 
		 * C
		 */
		Campo vizinhoDiagonalSuperiorEsquerdaMinado = inicializaCampoIsMinadoTrue(1, 2);
		assertTrue(vizinhoDiagonalSuperiorEsquerdaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalSuperiorEsquerdaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoDiagonalSuperiorEsquerdaMinado);
		
		/* M
		 *C
		 */
		Campo vizinhoDiagonalSuperiorDireitaMinado = inicializaCampoIsMinadoTrue(1, 4);
		assertTrue(vizinhoDiagonalSuperiorDireitaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalSuperiorDireitaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoDiagonalSuperiorDireitaMinado);
		
		/* C
		 *M
		 */
		Campo vizinhoDiagonalInferiorEsquerdaMinado = inicializaCampoIsMinadoTrue(3, 2);
		assertTrue(vizinhoDiagonalInferiorEsquerdaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalInferiorEsquerdaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoDiagonalInferiorEsquerdaMinado);
		
		/* C
		 *  M
		 */
		Campo vizinhoDiagonalInferiorDireitaMinado = inicializaCampoIsMinadoTrue(3, 4);
		assertTrue(vizinhoDiagonalInferiorDireitaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalInferiorDireitaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		campoService.reiniciarCampo(vizinhoDiagonalInferiorDireitaMinado);
	}
	
	@Test
	void getQtdMinasVizinhanca_WithVariosMinados_ExpectCorrectResult(){
		/*C(2, 3*/
		
		/*CM*/
		Campo vizinhoDireitaMinado = inicializaCampoIsMinadoTrue(2, 4);
		assertTrue(vizinhoDireitaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDireitaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 1);
		
		/*MC*/
		Campo vizinhoEsquerdaMinado = inicializaCampoIsMinadoTrue(2, 2);
		assertTrue(vizinhoEsquerdaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoEsquerdaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 2);
		
		/* M
		 * C*/
		Campo vizinhoCimaMinado = inicializaCampoIsMinadoTrue(1, 3);
		assertTrue(vizinhoCimaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoCimaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 3);
		
		/* C
		 * M*/
		Campo vizinhoBaixoMinado = inicializaCampoIsMinadoTrue(3, 3);
		assertTrue(vizinhoBaixoMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoBaixoMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 4);
		
		/*M 
		 * C
		 */
		Campo vizinhoDiagonalSuperiorEsquerdaMinado = inicializaCampoIsMinadoTrue(1, 2);
		assertTrue(vizinhoDiagonalSuperiorEsquerdaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalSuperiorEsquerdaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 5);
		
		/* M
		 *C
		 */
		Campo vizinhoDiagonalSuperiorDireitaMinado = inicializaCampoIsMinadoTrue(1, 4);
		assertTrue(vizinhoDiagonalSuperiorDireitaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalSuperiorDireitaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 6);
		
		/* C
		 *M
		 */
		Campo vizinhoDiagonalInferiorEsquerdaMinado = inicializaCampoIsMinadoTrue(3, 2);
		assertTrue(vizinhoDiagonalInferiorEsquerdaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalInferiorEsquerdaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 7);
		
		/* C
		 *  M
		 */
		Campo vizinhoDiagonalInferiorDireitaMinado = inicializaCampoIsMinadoTrue(3, 4);
		assertTrue(vizinhoDiagonalInferiorDireitaMinado.isMinado());
		campoService.adicionaVizinho(central, vizinhoDiagonalInferiorDireitaMinado);
		assertEquals(campoService.getQtdMinasVizinhanca(central), 8);
	}
	
	@Test
	void abrirCampoSelecionado_ExpectCampoAbertoOrExplosaoException(){
		try {
			campoService.abrirCampoSelecionado(3, 3, tabuleiro.getCampos());
			Campo campo = this.getCampoPelaCoordenada(3, 3, tabuleiro.getCampos());
			assertTrue(campo.isStatusCampoAberto());
		}catch(Exception e){
			assertEquals(ExplosaoException.class, e.getClass());
		}
	}	
	
	@Test
	void marcarCampoSelecionado_ExpectCampoMarcado(){
		campoService.marcarCampoSelecionado(4, 4, tabuleiro.getCampos());
		Campo campo = this.getCampoPelaCoordenada(4, 4, tabuleiro.getCampos());
		assertTrue(campo.isMarcado());
	}
	
	private Campo getCampoPelaCoordenada(int linha, int coluna, List<Campo> campos) {
		Campo campo = campos.parallelStream()
			.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			.findFirst().get();
		
		return campo;
	}
	
	private Campo inicializaCampoIsMarcadoTrue() {
		Campo campo = new Campo(5, 8);
		campoService.alterarMarcacao(campo);
		return campo;
	}
	
	private Campo inicializaCampoIsMinadoTrue(int linha, int coluna) {
		Campo campo = new Campo(linha, coluna);
		campoService.minarCampo(campo);
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
