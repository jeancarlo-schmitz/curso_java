package main.java.br.com.strolker.campo.minado.modules.observer;

import main.java.br.com.strolker.campo.minado.modules.domain.Campo;

@FunctionalInterface
public interface CampoObserver {

	public void eventoOcorreu(Campo campo, CampoEvent event);
}
