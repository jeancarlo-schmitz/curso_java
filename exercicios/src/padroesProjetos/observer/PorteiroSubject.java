package padroesProjetos.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PorteiroSubject {
	
	List<ChegadaAniversarianteObserver> observers = new ArrayList<>();

	
	public void registarObserver(ChegadaAniversarianteObserver observer) {
		observers.add(observer);
	}
	
	public void monitorar() {
		Scanner scanner = new Scanner(System.in);
		
		String valor = "";
		while(!valor.equalsIgnoreCase("sair")) {
			
			System.out.println("O aniversariante chegou?");
			valor = scanner.nextLine();
			if(valor.equalsIgnoreCase("sim")) {
				
				ChegadaAniversarianteEvent event = new ChegadaAniversarianteEvent(new Date());
				
				observers.stream().forEach(observer -> observer.chegou(event));
				valor = "sair";
			}else {
				System.out.println("Alarme Falso");
			}
			
		}
		
		scanner.close();
	}
}
