package fundamentos.desafios;

public class DesafiosAritmeticos_meu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double somaValores = 0;
		
		double primeiro = 6*(3+2);
		primeiro = Math.pow(primeiro, 2);
		primeiro = primeiro / (3*2);
		
		double segundo = (1-5) * (2-7);
		double divisaoSegundo = Math.pow(2, 2);
		segundo = Math.pow(segundo, 2);
		segundo = segundo/divisaoSegundo;
		System.out.println(primeiro);
		System.out.println(segundo);
		
		double resultPrimeiraEquacao = (primeiro-segundo);
		resultPrimeiraEquacao = Math.pow(resultPrimeiraEquacao, 3);
		double divisaoResultado = Math.pow(10, 3);
		double resultadoEquacao = resultPrimeiraEquacao/divisaoResultado;
		
		System.out.println("O resultado da equação é: " + (int)resultadoEquacao);
		
		

	}

}
