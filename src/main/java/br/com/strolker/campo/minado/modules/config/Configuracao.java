package main.java.br.com.strolker.campo.minado.modules.config;

public class Configuracao {

	public static int qtdLinhas;
	public static int qtdColunas;
	public static int qtdBombas;
	public static String titleJogo = "Campo Minado";
	public static int width = 690;
	public static int height = 438;
	public static String modoJogo = "interface";
	public static int qtdMaximaLinhas = 20;
	public static int qtdMaximaColunas = 20;
	public static int qtdMaximaBombas;
	
	public static int getQtdMaximaBombas() {
		int substrair;
		if(qtdLinhas < 3) {
			substrair = qtdLinhas;
		}else if(qtdLinhas <= 8) {
			substrair = qtdLinhas + qtdColunas + 5;
		}else if(qtdLinhas <= 13){
			substrair = ((qtdLinhas * 2)  + (qtdColunas * 2)) - 10;
		}else {
			substrair = ((qtdLinhas * 3)  + (qtdColunas * 3)) - 10;
		}
		qtdMaximaBombas = (qtdLinhas * qtdColunas) - substrair;
		return qtdMaximaBombas;
	}
	
	public static boolean isInterface() {
		return modoJogo.equals("interface");
	}
}
