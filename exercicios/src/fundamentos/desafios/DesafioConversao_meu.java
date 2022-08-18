package fundamentos.desafios;

import java.util.Scanner;

public class DesafioConversao_meu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int qtdSalarios = 0;
		
		System.out.println("Digite Seu Primeiro Salário");
		
		double salario1 = Double.parseDouble(scan.nextLine().replace(',', '.'));
		qtdSalarios++;
		System.out.println("Digite Seu Segundo Salário");
		
		double salario2 = Double.parseDouble(scan.nextLine().replace(',', '.'));
		qtdSalarios++;

		double somaSalario = salario1 + salario2;
		double mediaSalario = somaSalario / qtdSalarios;
		
		System.out.println("A soma dos salários são: " + somaSalario );
		System.out.println("A médio dos salários é: " + mediaSalario );
		
		scan.close();

	}

}
