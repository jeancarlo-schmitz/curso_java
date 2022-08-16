package main.java.br.com.strolker.campo.minado.modules.domain;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.strolker.campo.minado.modules.service.CampoService;

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
			return "x";
		}else if(isStatusCampoAberto() && minado) {
			return "*";
		}else if(isStatusCampoAberto() && campoService.getQtdMinasVizinhanca(this) > 0) {
			return Long.toString(campoService.getQtdMinasVizinhanca(this));
		}else if(isStatusCampoAberto()) {
			return " ";
		}
		return "?";
	}
}
