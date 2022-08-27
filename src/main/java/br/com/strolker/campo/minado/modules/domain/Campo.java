package main.java.br.com.strolker.campo.minado.modules.domain;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.strolker.campo.minado.modules.observer.CampoObserver;
import main.java.br.com.strolker.campo.minado.modules.service.CampoService;
import main.java.br.com.strolker.campo.minado.modules.service.utils.CoresPadrao;

public class Campo {
	private final int linha;
	private final int coluna;
	
	private StatusCampo statusCampo;
	private boolean marcado;
	private boolean minado;

	private List<Campo> vizinhanca = new ArrayList<>();
	private List<CampoObserver> observers = new ArrayList<>();
	
	public Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
		this.statusCampo = StatusCampo.FECHADO;
	}

	public List<Campo> getVizinhanca() {
		return vizinhanca;
	}

	public void setVizinhanca(List<Campo> vizinhanca) {
		this.vizinhanca = vizinhanca;
	}
	
	public List<CampoObserver> getObservers() {
		return observers;
	}

	public void addObserver(CampoObserver observer) {
		this.observers.add(observer);
	}
	
	public StatusCampo getStatusCampo() {
		return statusCampo;
	}

	public void setStatusCampo(StatusCampo statusCampo) {
		this.statusCampo = statusCampo;
	}

	public void setStatusCampoAberto() {
		this.statusCampo = StatusCampo.ABERTO;
	}
	
	public void setStatusCampoFechado() {
		this.statusCampo = StatusCampo.FECHADO;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}
	
	public boolean isMinado() {
		return minado;
	}

	public void setMinado(boolean minado) {
		this.minado = minado;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	public boolean isStatusCampoAberto() {
		return statusCampo.equals(StatusCampo.ABERTO);
	}
	
	public boolean isStatusCampoFechado() {
		return statusCampo.equals(StatusCampo.FECHADO);
	}
	
	public String toString() {
		CampoService campoService = new CampoService();
		if(marcado) {
			return CoresPadrao.ANSI_RED + "X" + CoresPadrao.ANSI_RESET;
		}else if(isStatusCampoAberto() && minado) {
			return CoresPadrao.ANSI_YELLOW + CoresPadrao.ANSI_NEGRITO + "*" + CoresPadrao.ANSI_RESET;
		}else if(isStatusCampoAberto() && campoService.getQtdMinasVizinhanca(this) > 0) {
			String qtdMinasVizinhanca = Long.toString(campoService.getQtdMinasVizinhanca(this));
			StringBuilder sb = new StringBuilder();
			switch (qtdMinasVizinhanca) {
				case "1": {
					sb.append(CoresPadrao.ANSI_YELLOW);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "2": {
					sb.append(CoresPadrao.ANSI_BLUE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "3": {
					sb.append(CoresPadrao.ANSI_GREEN);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "4": {
					sb.append(CoresPadrao.ANSI_PURPLE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "5": {
					sb.append(CoresPadrao.ANSI_CYAN);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "6": {
					sb.append(CoresPadrao.ANSI_RED);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "7": {
					sb.append(CoresPadrao.ANSI_BLUE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "8": {
					sb.append(CoresPadrao.ANSI_PURPLE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
			}

			sb.append(CoresPadrao.ANSI_RESET);
			return sb.toString();
		}else if(isStatusCampoAberto()) {
			return " ";
		}
		return "?";
	}
}
