package generics.semGenerics;

public class CaixaObjetoTeste {

	public static void main(String[] args) {
		CaixaObjeto caixaA = new CaixaObjeto();
		caixaA.setCoisa(2.3);
		Double teste = (Double) caixaA.getCoisa();
		System.out.println(teste);
		
		CaixaObjeto caixaB = new CaixaObjeto();
		caixaB.setCoisa("Olá Mundo!! :)");
		String testeB = (String) caixaB.getCoisa();
		System.out.println(testeB);

	}

}
