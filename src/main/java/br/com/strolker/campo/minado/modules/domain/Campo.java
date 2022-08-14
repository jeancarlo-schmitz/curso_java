package main.java.br.com.strolker.campo.minado.modules.domain;

import java.util.ArrayList;
import java.util.List;

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
}
