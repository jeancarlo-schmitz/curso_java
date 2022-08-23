package generics.comGenerics;

public class CaixaGenericsTeste {

	public static void main(String[] args) {
		CaixaGenerics<String> caixaA = new CaixaGenerics<>();
		caixaA.setCoisa("Teste!");
		String testeA = caixaA.getCoisa();
		System.out.println(testeA);
		
		CaixaGenerics<Double> caixaB = new CaixaGenerics<>();
		caixaB.setCoisa(2.34423);
		Double testeB = caixaB.getCoisa();
		System.out.println(testeB);

	}

}
