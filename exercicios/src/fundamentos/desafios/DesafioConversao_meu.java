package fundamentos.desafios;

import java.util.Scanner;

public class DesafioConversao_meu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int qtdSalarios = 0;
		
		System.out.println("Digite Seu Primeiro Sal�rio");
		
		double salario1 = Double.parseDouble(scan.nextLine().replace(',', '.'));
		qtdSalarios++;
		System.out.println("Digite Seu Segundo Sal�rio");
		
		double salario2 = Double.parseDouble(scan.nextLine().replace(',', '.'));
		qtdSalarios++;

		double somaSalario = salario1 + salario2;
		double mediaSalario = somaSalario / qtdSalarios;
		
		System.out.println("A soma dos sal�rios s�o: " + somaSalario );
		System.out.println("A m�dio dos sal�rios �: " + mediaSalario );
		
		scan.close();

	}

}
