package main.java.br.com.strolker.campo.minado.modules;

import main.java.br.com.strolker.campo.minado.modules.domain.Configuracao;
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.service.ConfiguracaoService;
import main.java.br.com.strolker.campo.minado.modules.view.TabuleiroConsole;

public class Aplicacao {
  
	public static void main(String[] args) {
		ConfiguracaoService.setConfiguracoesJogo();
		int qtdLinhas = Configuracao.qtdLinhas;
		int qtdColunas = Configuracao.qtdColunas;
		int qtdBombas = Configuracao.qtdBombas;
		
		Tabuleiro tabuleiro = new Tabuleiro(qtdLinhas, qtdColunas, qtdBombas);
		new TabuleiroConsole(tabuleiro);
	}

}