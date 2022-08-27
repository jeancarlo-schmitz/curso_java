package main.java.br.com.strolker.campo.minado.modules;

import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;
import main.java.br.com.strolker.campo.minado.modules.service.TabuleiroService;

public class Temp {
	
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(3, 3, 9);
		CampoService campoService = new CampoService();
		TabuleiroService tabuleiroService = new TabuleiroService();
		
		tabuleiroService.adicionarObservador(tabuleiro, e -> {
			if(e.isGanhou()) {

				System.out.println("Ganhouu!!");
			}else {
				System.out.println("Perdeu he!!");
			}
		});
		
		campoService.marcarCampoSelecionado(0, 0, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(0, 1, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(0, 2, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(1, 0, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(1, 1, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(1, 2, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(2, 0, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(2, 1, tabuleiro.getCampos());
		campoService.marcarCampoSelecionado(2, 2, tabuleiro.getCampos());
		
	}

}
