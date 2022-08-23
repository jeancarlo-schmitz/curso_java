package padroesProjetos.observer;

public class Namorada implements ChegadaAniversarianteObserver {

	public void chegou(ChegadaAniversarianteEvent event) {
		System.out.println("Avisar que chegou");
		System.out.println("Apagar as luzes...");
		System.out.println("Esperar um pouco...");
		System.out.println("Surpresa!!!");
		
	}

	
}
