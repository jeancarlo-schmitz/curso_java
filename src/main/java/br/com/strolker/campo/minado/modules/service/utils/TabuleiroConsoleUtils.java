package main.java.br.com.strolker.campo.minado.modules.service.utils;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.br.com.strolker.campo.minado.modules.exception.SairException;

public class TabuleiroConsoleUtils {

	public String capturarValorDigitado(String texto, Scanner scanner) {
		System.out.print(texto);
		String valorDigitado = scanner.nextLine();
		
		if(valorDigitado.equalsIgnoreCase("sair")) {
			throw new SairException();
		}
		
		return valorDigitado;
	}
	
	public ArrayList<Integer> extrairDadosDigitados(String valorDigitado) {

		ArrayList<Integer> coordenadasDigitadas = new ArrayList<>();
		try {
			String[] dadosDigitados = valorDigitado.split(",");
			for (int i = 0; i < dadosDigitados.length; i++) {
				coordenadasDigitadas.add(stringToInt(dadosDigitados[i].trim()));
			}
		} catch (Exception e) {
			coordenadasDigitadas.add(-1);
		}

		return coordenadasDigitadas;
	}
	
	public boolean verificaCoordenadasDigitadasCorretas(ArrayList<Integer> coordenadasDigitadas, int linhaTabuleiro, int colunaTabuleiro) {
		if(coordenadasDigitadas.size() != 2) {
			return false;
		}
		
		int linha = coordenadasDigitadas.get(0);
		int coluna = coordenadasDigitadas.get(1);
		
		if(linha >= linhaTabuleiro || coluna >= colunaTabuleiro) {
			return false;
		}
		
		return true;
	}
	
	public boolean verificaOpcaoDigitadaCorretamente(String valorDigitado) {

		try {
			int opcaoDigitada = stringToInt(valorDigitado);
			if(opcaoDigitada == 1 || opcaoDigitada == 2) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int getOpcaoDigitada(String valorDigitado) {
		return stringToInt(valorDigitado);
	}
	
	private int stringToInt(String string) {
		return Integer.parseInt(string.trim());
	}
}
