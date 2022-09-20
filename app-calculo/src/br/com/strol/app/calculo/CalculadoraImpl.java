package br.com.strol.app.calculo;

import br.com.strol.app.Calculadora;
import br.com.strol.app.calculo.interno.OperacoesAritmeticas;
import br.com.strol.app.loggin.Logger;

public class CalculadoraImpl implements Calculadora {

	private OperacoesAritmeticas opAritmetica = new OperacoesAritmeticas();

	public double soma(double... nums) {
		Logger.info("Somando....");
		return opAritmetica.soma(nums);
	}
}
