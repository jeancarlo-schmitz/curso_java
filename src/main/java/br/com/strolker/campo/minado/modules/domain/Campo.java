package main.java.br.com.strolker.campo.minado.modules.domain;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.strolker.campo.minado.modules.service.CampoService;
import main.java.br.com.strolker.campo.minado.modules.service.utils.ColorindoConsole;

public class Campo {
	private final int linha;
	private final int coluna;
	
	private StatusCampo statusCampo;
	private boolean marcado;
	private boolean minado;

	private List<Campo> vizinhanca = new ArrayList<>();
	
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
			return ColorindoConsole.ANSI_RED + "X" + ColorindoConsole.ANSI_RESET;
		}else if(isStatusCampoAberto() && minado) {
			return ColorindoConsole.ANSI_YELLOW + ColorindoConsole.ANSI_NEGRITO + "*" + ColorindoConsole.ANSI_RESET;
		}else if(isStatusCampoAberto() && campoService.getQtdMinasVizinhanca(this) > 0) {
			String qtdMinasVizinhanca = Long.toString(campoService.getQtdMinasVizinhanca(this));
			StringBuilder sb = new StringBuilder();
			switch (qtdMinasVizinhanca) {
				case "1": {
					sb.append(ColorindoConsole.ANSI_YELLOW);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "2": {
					sb.append(ColorindoConsole.ANSI_BLUE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "3": {
					sb.append(ColorindoConsole.ANSI_GREEN);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "4": {
					sb.append(ColorindoConsole.ANSI_PURPLE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "5": {
					sb.append(ColorindoConsole.ANSI_CYAN);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "6": {
					sb.append(ColorindoConsole.ANSI_RED);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "7": {
					sb.append(ColorindoConsole.ANSI_BLUE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
				case "8": {
					sb.append(ColorindoConsole.ANSI_PURPLE);
					sb.append(qtdMinasVizinhanca);
					break;
				}
			}

			sb.append(ColorindoConsole.ANSI_RESET);
			return sb.toString();
		}else if(isStatusCampoAberto()) {
			return " ";
		}
		return "?";
	}
}
