package main.java.br.com.strolker.campo.minado.modules.service.utils;

import java.util.Scanner;

import main.java.br.com.strolker.campo.minado.modules.exception.DefaultConfigException;
import main.java.br.com.strolker.campo.minado.modules.exception.SairException;

public class ConfiguracaoUtils {
	
	public String capturarValorDigitado(String texto, Scanner scanner) {
		System.out.print(texto);
		String valorDigitado = scanner.nextLine();
		
		if(valorDigitado.equalsIgnoreCase("sair")) {
			throw new SairException();
		}
		
		if(valorDigitado.equalsIgnoreCase("default")) {
			throw new DefaultConfigException();
		}
		
		return valorDigitado;
	}
	
	public boolean verificaSeValorDigitadoCorretamente(String valorDigitado, int valorMaximo) {
		try {
			int valor = stringToInt(valorDigitado);
			
			if(valor > valorMaximo || valor < 2) {
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int stringToInt(String string) {
		return Integer.parseInt(string.trim());
	}
}
