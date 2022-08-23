package generics.comGenerics.heranca;

public class CaixaNumeroTeste {

	public static void main(String[] args) {
		CaixaNumero<Double> caixaDouble = new CaixaNumero<>();
		CaixaNumero<Integer> caixaInteger = new CaixaNumero<>();
		CaixaNumero<Float> caixaFloat = new CaixaNumero<>();
		CaixaNumero<Long> caixaLong = new CaixaNumero<>();
		
		caixaDouble.setCoisa(2.3);
		Double testeDouble = caixaDouble.getCoisa();
		System.out.println("TESTE DOUBLE: " + testeDouble);

		caixaInteger.setCoisa(22583);
		Integer testeInteger = caixaInteger.getCoisa();
		System.out.println("TESTE INTEGER: " + testeInteger);
		
		caixaFloat.setCoisa(225.83F);
		Float testeFloat = caixaFloat.getCoisa();
		System.out.println("TESTE FLOAT: " + testeFloat);
		
		caixaLong.setCoisa(22583L);
		Long testeLong = caixaLong.getCoisa();
		System.out.println("TESTE LONG: " + testeLong);
		

	}

}
