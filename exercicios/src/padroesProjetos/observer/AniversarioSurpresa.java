package padroesProjetos.observer;

public class AniversarioSurpresa {

	public static void main(String[] args) {
		Namorada namorada = new Namorada();
		PorteiroSubject porteiro = new PorteiroSubject();
		
		porteiro.registarObserver(namorada);
		porteiro.monitorar();

	}

}
