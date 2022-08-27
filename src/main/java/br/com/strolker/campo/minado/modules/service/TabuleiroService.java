package main.java.br.com.strolker.campo.minado.modules.service;

import java.util.List;
import java.util.function.Consumer;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.domain.ResultadoEvento;
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;

public class TabuleiroService{

	private CampoService campoService = new CampoService();
	
	public void gerarCampos(int qtdLinhas, int qtdColunas, Tabuleiro tabuleiro){
		for (int linha = 0; linha < qtdLinhas; linha++) {
			for (int coluna = 0; coluna < qtdColunas; coluna++) {
				Campo campo = new Campo(linha, coluna);
				campoService.adicionarObservador(campo, tabuleiro);
				tabuleiro.adicionarCampo(campo);
			}
		}
	}

	public void associarVizinhos(List<Campo> campos){
		for (Campo campo1 : campos) {
			for (Campo campo2 : campos) {
				campoService.adicionaVizinho(campo1, campo2);
			}
		}
	}
	
	public void sortearMinas(int qtdMinas, List<Campo> campos){
		long qtdMinasArmadas = 0;
		
		while (qtdMinasArmadas < qtdMinas) { 
			int aleatorio = (int) (Math.random() * campos.size());
			campoService.minarCampo(campos.get(aleatorio));
			qtdMinasArmadas = campos.stream().filter(c -> c.isMinado()).count();
		} 
	}
	
	public boolean isObjetivoJogoAlcancado(List<Campo> campos) {
		return campos.stream().allMatch(c -> campoService.isObjetivoCampoAlcancado(c));
	}
	
	public void reiniciarTabuleiro(int qtdMinas, List<Campo> campos) {
		campos.stream().forEach(c -> campoService.reiniciarCampo(c));
		sortearMinas(qtdMinas, campos);
	}
	
	public void adicionarObservador(Tabuleiro tabuleiro, Consumer<ResultadoEvento> observer) {
		tabuleiro.addObserver(observer);
	}
	
	public void notificarObservadores(Tabuleiro tabuleiro, boolean event) {
		List<Consumer<ResultadoEvento>> observers = tabuleiro.getObservers();
		observers.stream().forEach(o -> o.accept(new ResultadoEvento(event)));
	}
	
	public void forEach(Consumer<Campo> funcao, Tabuleiro tabuleiro) {
		tabuleiro.getCampos().forEach(funcao);
	}
}
