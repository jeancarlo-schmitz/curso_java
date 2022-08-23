package padroesProjetos.observer;

import java.util.Date;

public class ChegadaAniversarianteEvent {

	private final Date dataEvento;

	public ChegadaAniversarianteEvent(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Date getDataEvento() {
		return dataEvento;
	}
	
}
