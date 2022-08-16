package main.java.br.com.strolker.campo.minado.modules.domain;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.strolker.campo.minado.modules.service.TabuleiroService;

public class Tabuleiro {
	
	TabuleiroService tabuleiroService;
	
	private int linhas;
	private int colunas;
	private int qtdMinas;
	
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int qtdMinas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.qtdMinas = qtdMinas;
		
		tabuleiroService = new TabuleiroService();
		
		tabuleiroService.gerarCampos(linhas, colunas, this);
		tabuleiroService.associarVizinhos(campos);
		tabuleiroService.sortearMinas(qtdMinas, campos);
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public int getQtdMinas() {
		return qtdMinas;
	}
	
	public void adicionarCampo(Campo campo) {
		campos.add(campo);
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		int index = 0;
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				sb.append(" ");
				sb.append(campos.get(index));
				sb.append(" ");
				index++;
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
