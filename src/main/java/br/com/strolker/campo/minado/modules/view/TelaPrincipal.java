package main.java.br.com.strolker.campo.minado.modules.view;

import javax.swing.JFrame;

import main.java.br.com.strolker.campo.minado.modules.config.Configuracao;
import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	TelaPrincipal(){
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);
		
		add(new PainelTabuleiro(tabuleiro));
				
			
		setTitle(Configuracao.titleJogo);
		setSize(Configuracao.width, Configuracao.height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
