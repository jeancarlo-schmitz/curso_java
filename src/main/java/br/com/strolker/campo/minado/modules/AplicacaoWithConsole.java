package main.java.br.com.strolker.campo.minado.modules;

import main.java.br.com.strolker.campo.minado.modules.config.Configuracao;
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.service.ConfiguracaoService;
import main.java.br.com.strolker.campo.minado.modules.view.TabuleiroConsole;

public class AplicacaoWithConsole {
  
	public static void main(String[] args) {
		ConfiguracaoService.setConfiguracoesJogo();
		int qtdLinhas = Configuracao.qtdLinhas;
		int qtdColunas = Configuracao.qtdColunas;
		int qtdBombas = Configuracao.qtdBombas;
		Configuracao.modoJogo = "console";
		
		Tabuleiro tabuleiro = new Tabuleiro(qtdLinhas, qtdColunas, qtdBombas);
		new TabuleiroConsole(tabuleiro);
	}

}