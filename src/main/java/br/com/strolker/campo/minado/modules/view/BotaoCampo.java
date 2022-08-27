package main.java.br.com.strolker.campo.minado.modules.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import main.java.br.com.strolker.campo.minado.modules.config.BotaoMouseConfig;
import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.observer.CampoEvent;
import main.java.br.com.strolker.campo.minado.modules.observer.CampoObserver;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;
import main.java.br.com.strolker.campo.minado.modules.service.utils.CoresPadrao;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObserver, MouseListener {

	private Campo campo;
	private CampoService campoService;
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		campoService = new CampoService();
		
		setBackground(CoresPadrao.BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		campo.addObserver(this);
	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvent event) {
		switch (event) {
			case ABRIR: 
				aplicarEstiloAbrir();
				break;
			case MARCAR: 
				aplicarEstiloMarcar();
				break;
			case EXPLODIR: 
				aplicarEstiloExplodir();
				break;
			default: 
				aplicarEstiloPadrao();
				break;
		}
	}

	private void aplicarEstiloPadrao() {
		setBackground(CoresPadrao.BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
		
	}

	private void aplicarEstiloExplodir() {
		setBackground(CoresPadrao.BG_EXPLODIR);
		setForeground(Color.WHITE);
		setText("X");
	}

	private void aplicarEstiloMarcar() {
		setBackground(CoresPadrao.BG_MARCAR);
		setForeground(Color.BLACK);
		setText("M");
		
	}

	private void aplicarEstiloAbrir() {
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		if(campo.isMinado()) {
			setBackground(CoresPadrao.BG_EXPLODIR);
			return;
		}
		
		setBackground(CoresPadrao.BG_PADRAO);
		String qtdMinasVizinhanca = Long.toString(campoService.getQtdMinasVizinhanca(campo));
		
		switch (qtdMinasVizinhanca) {
			case "1": 
				setForeground(CoresPadrao.TEXTO_VERDE);
				break;
			case "2": 
				setForeground(Color.BLUE);
				break;
			case "3": 
				setForeground(Color.YELLOW);
				break;
			case "4": 
				setForeground(Color.CYAN);
				break;
			case "5":
			case "6":
				setForeground(Color.RED);
				break;
			default:
				setForeground(Color.PINK);
				break;
		}
		String valor = campoService.isVizinhancaSegura(campo) ? "" : qtdMinasVizinhanca;
		setText(valor);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == BotaoMouseConfig.BOTAO_ESQUERDO) {
			campoService.abrirCampo(campo);
		}else if(e.getButton() == BotaoMouseConfig.BOTAO_DIREITO) {
			campoService.alterarMarcacao(campo);
		}
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
