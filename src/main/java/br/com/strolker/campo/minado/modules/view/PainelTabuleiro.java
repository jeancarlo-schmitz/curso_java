package main.java.br.com.strolker.campo.minado.modules.view;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.java.br.com.strolker.campo.minado.modules.domain.Tabuleiro;
import main.java.br.com.strolker.campo.minado.modules.service.TabuleiroService;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		TabuleiroService tabuleiroService = new TabuleiroService();
		int linhas = tabuleiro.getLinhas();
		int colunas = tabuleiro.getColunas();
		setLayout(new GridLayout(linhas, colunas));
		
		tabuleiroService.forEach(c -> add(new BotaoCampo(c)), tabuleiro);
		
		tabuleiro.addObserver(e ->{
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou()) {
					JOptionPane.showMessageDialog(this, "Você Ganhou :D");
				}else {
					JOptionPane.showMessageDialog(this, "Você Perdeu :(");
				}
				
				tabuleiroService.reiniciarTabuleiro(tabuleiro.getQtdMinas(), tabuleiro.getCampos());
			});
		});
	}
}
