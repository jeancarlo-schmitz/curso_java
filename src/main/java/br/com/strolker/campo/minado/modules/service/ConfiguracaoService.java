package main.java.br.com.strolker.campo.minado.modules.service;

import java.util.Scanner;

import main.java.br.com.strolker.campo.minado.modules.config.Configuracao;
import main.java.br.com.strolker.campo.minado.modules.exception.DefaultConfigException;
import main.java.br.com.strolker.campo.minado.modules.service.utils.ConfiguracaoUtils;

public class ConfiguracaoService {

	public static void setConfiguracoesJogo() {
		Scanner scanner = new Scanner(System.in);
		ConfiguracaoUtils utils = new ConfiguracaoUtils();
		System.out.println("Para Iniciar com as configurações padrões escreve: default");
		System.out.println("Para sair do jogo escreva a qualquer momento: sair");
		String valorDigitado;
		try {
			boolean valorValidado = true;
			do {
				valorDigitado = utils.capturarValorDigitado("Digite a quantidade de linhas (máximo " + Configuracao.qtdMaximaLinhas + " ): ", scanner);
				if(utils.verificaSeValorDigitadoCorretamente(valorDigitado, Configuracao.qtdMaximaLinhas)) {
					valorValidado = true;
					Configuracao.qtdLinhas = utils.stringToInt(valorDigitado);
				}else {
					valorValidado = false;
					System.out.println("Valor digitado incorretamente, digite novamente!");
				}
			} while(!valorValidado);
			
			do {
				valorDigitado = utils.capturarValorDigitado("Digite a quantidade de colunas (máximo " + Configuracao.qtdMaximaColunas + " ): ", scanner);
				if(utils.verificaSeValorDigitadoCorretamente(valorDigitado, Configuracao.qtdMaximaColunas)) {
					valorValidado = true;
					Configuracao.qtdColunas = utils.stringToInt(valorDigitado);
				}else {
					valorValidado = false;
					System.out.println("Valor digitado incorretamente, digite novamente!");
				}
			} while(!valorValidado);
			
			do {
				valorDigitado = utils.capturarValorDigitado("Digite a quantidade de bombas (máximo " + Configuracao.getQtdMaximaBombas() + " ): ", scanner);
				if(utils.verificaSeValorDigitadoCorretamente(valorDigitado, Configuracao.qtdMaximaBombas)) {
					valorValidado = true;
					Configuracao.qtdBombas = utils.stringToInt(valorDigitado);
				}else {
					valorValidado = false;
					System.out.println("Valor digitado incorretamente, digite novamente!");
				}
			} while(!valorValidado);
		} catch(DefaultConfigException e) {
			Configuracao.qtdLinhas = 20;
			Configuracao.qtdColunas = 20;
			Configuracao.qtdBombas = 40;
		}
	}
}
