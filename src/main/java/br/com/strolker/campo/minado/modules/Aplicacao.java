package main.java.br.com.strolker.campo.minado.modules;

import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;

public class Aplicacao {
	
	public static void main(String[] args) {
		CampoService campoService = new CampoService(); 
		Tabuleiro tabuleiro = new Tabuleiro(1, 1, 1);
		campoService.abrirCampoSelecionado(3, 3, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(4, 4, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(4, 5, tabuleiro.getCampos());
		
		
		System.out.println(tabuleiro.toString());
	}

}
