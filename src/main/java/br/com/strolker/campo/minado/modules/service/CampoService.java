package main.java.br.com.strolker.campo.minado.modules.service;

import java.util.List;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.domain.StatusCampo;
import main.java.br.com.strolker.campo.minado.modules.exception.ExplosaoException;

public class CampoService {
	
	public boolean adicionaVizinho(Campo central, Campo vizinho) {
		boolean adicionado = false;
		
		if(vizinho.getLinha() >= 0 && vizinho.getColuna() >= 0) {
			if(Boolean.TRUE.equals(this.isVizinho(central, vizinho))) {
				adicionado = true;
				List<Campo> vizinhanca = central.getVizinhanca();
				vizinhanca.add(vizinho);
				central.setVizinhanca(vizinhanca);
			}
		}
		
		return adicionado;
	}
	
	public void alterarMarcacao(Campo campo) {
		if(campo.isStatusCampoFechado()) {
			campo.setMarcado(!campo.isMarcado());
		}
	}
	
	public boolean abrirCampo(Campo campo) {
		
		if(campo.isStatusCampoFechado() &&
		   Boolean.FALSE.equals(campo.isMarcado())) {
			campo.setStatusCampo(StatusCampo.ABERTO);
			
			if(campo.isMinado()) {
				throw new ExplosaoException();
			}
			
			if(this.isVizinhancaSegura(campo)) {
				campo.getVizinhanca().forEach(vizinho -> abrirCampo(vizinho));
			}
			
			return true;
		}
		
		return false;
	}
	
	public void abrirCampoSelecionado(int linha, int coluna, List<Campo> campos) {
		campos.parallelStream()
			  .filter(campo -> campo.getLinha() == linha && campo.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(campo -> this.abrirCampo(campo));
	}
	
	public void marcarCampoSelecionado(int linha, int coluna, List<Campo> campos) {
		campos.parallelStream()
			  .filter(campo -> campo.getLinha() == linha && campo.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(campo -> this.alterarMarcacao(campo));
	}
	
	public void minarCampo(Campo campo) {
		if(campo.isStatusCampoFechado()) {
			campo.setMinado(true);
		}
	}
	
	public boolean isObjetivoCampoAlcancado(Campo campo) {
		boolean campoDesvendado = !campo.isMinado() && campo.isStatusCampoAberto();
		boolean campoProtegido  = campo.isMinado() && campo.isMarcado();
		
		return campoDesvendado || campoProtegido;
	}
	
	public void reiniciarCampo(Campo campo) {
		campo.setMarcado(false);
		campo.setMinado(false);
		campo.setStatusCampo(StatusCampo.FECHADO);
	}
	
	public long getQtdMinasVizinhanca(Campo campo) {
		return campo.getVizinhanca().stream().filter(c -> c.isMinado()).count();
	}
	
	private boolean isVizinhancaSegura(Campo campo) {
		return campo.getVizinhanca().parallelStream().noneMatch(vizinho -> Boolean.TRUE.equals(vizinho.isMinado()));
	}
	
	private boolean isVizinho(Campo central, Campo vizinho) {
		int colunaCentral = central.getColuna();
		int linhaCentral = central.getLinha();
		int colunaVizinho = vizinho.getColuna();
		int linhaVzinho = vizinho.getLinha();
		
		int diferencaLinha  = Math.abs(Math.subtractExact(linhaCentral, linhaVzinho));
		int diferencaColuna = Math.abs(Math.subtractExact(colunaCentral, colunaVizinho));
		
		if(diferencaLinha > 1 || diferencaColuna > 1) {
			return false;
		}
		
		return true;
	}
}
