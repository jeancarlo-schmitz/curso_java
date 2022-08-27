package main.java.br.com.strolker.campo.minado.modules.service;

import java.util.List;

import main.java.br.com.strolker.campo.minado.modules.config.Configuracao;
import main.java.br.com.strolker.campo.minado.modules.domain.Campo;
import main.java.br.com.strolker.campo.minado.modules.domain.StatusCampo;
import main.java.br.com.strolker.campo.minado.modules.exception.ExplosaoException;
import main.java.br.com.strolker.campo.minado.modules.observer.CampoEvent;
import main.java.br.com.strolker.campo.minado.modules.observer.CampoObserver;

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
			
			if(Configuracao.isInterface()) {
				if(campo.isMarcado()) {
					notificarObservadores(campo, CampoEvent.MARCAR);
				}else {
					notificarObservadores(campo, CampoEvent.DESMARCAR);
				}
			}
		}
	}
	
	public boolean abrirCampo(Campo campo) {
		
		if(campo.isStatusCampoFechado() && !campo.isMarcado()) {
			
			if(campo.isMinado()) {
				if(Configuracao.isInterface()) {
					notificarObservadores(campo, CampoEvent.EXPLODIR);
					return true;
				}else {
					throw new ExplosaoException();
				}
			}
			
			this.setAberto(campo);
			
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
	
	public void abrirTodosOsCamposMinados(List<Campo> campos) {
		campos.parallelStream()
		  .filter(campo -> campo.isMinado() && !campo.isMarcado())
		  .forEach(campo -> this.setStatusCampoAberto(campo));
	}
	
	private void setStatusCampoAberto(Campo campo) {
		campo.setStatusCampoAberto();
		notificarObservadores(campo, CampoEvent.ABRIR);
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
		notificarObservadores(campo, CampoEvent.REINICIAR);
	}
	
	public long getQtdMinasVizinhanca(Campo campo) {
		return campo.getVizinhanca().stream().filter(c -> c.isMinado()).count();
	}
	
	public void adicionarObservador(Campo campo, CampoObserver observer) {
		campo.addObserver(observer);
	}
	
	private void notificarObservadores(Campo campo, CampoEvent event) {
		List<CampoObserver> observers = campo.getObservers();
		observers.stream().forEach(o -> o.eventoOcorreu(campo, event));
	}
	
	private void setAberto(Campo campo) {
		campo.setStatusCampo(StatusCampo.ABERTO);
		if(Configuracao.isInterface()) {
			notificarObservadores(campo, CampoEvent.ABRIR);
		}
	}
	
	public boolean isVizinhancaSegura(Campo campo) {
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
