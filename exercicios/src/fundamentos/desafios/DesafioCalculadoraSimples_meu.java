package fundamentos.desafios;

import java.util.Scanner;

public class DesafioCalculadoraSimples {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Primeiro Numero");
		double primeiroNumero = Double.parseDouble(scan.next());
		System.out.println("Segundo Numero");
		double segundoNumero = Double.parseDouble(scan.next());

		System.out.println("Operador");
		String operador = scan.next();
		double resultado = operador.equals("+") ? primeiroNumero + segundoNumero : operador.equals("-") ? primeiroNumero - segundoNumero : 
								operador.equals("/") ? primeiroNumero / segundoNumero: operador.equals("*") ? primeiroNumero * segundoNumero : primeiroNumero % segundoNumero;
								
		System.out.println(resultado);
		
		scan.close();
	}

}
