import br.com.strol.app.Calculadora;

module app.financeiro {
	
	requires java.base;
	requires app.api;
	uses Calculadora;
}