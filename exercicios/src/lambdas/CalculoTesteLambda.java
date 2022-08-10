package lambdas;

public class CalculoTesteLambda {
	
	public static void main(String[] args) {
		Calculo somar = (a, b) -> {return a+b;};
		Calculo multiplicar =  (a, b) -> a*b;
		System.out.println(somar.executar(3, 2));
		System.out.println(multiplicar.executar(3, 3));
	}
	
}
