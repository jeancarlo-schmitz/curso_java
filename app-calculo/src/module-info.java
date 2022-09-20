import br.com.strol.app.Calculadora;
import br.com.strol.app.calculo.CalculadoraImpl;

module app.calculo {
	exports br.com.strol.app.calculo;
	
//	exports br.com.strol.app.calculo.interno to app.financeiro, app.loggin;
//	opens br.com.strol.app.calculo;
	requires app.api;
	provides Calculadora with CalculadoraImpl;
	requires app.loggin;
}

/*open module app.calculo {}
 * Colocar o modulo como open, permite que possa acessar campos privados e alterar eles via java reflection Utilizando o 
 * Field field = Calculadora.class.getDeclaredFields()[0];
 * field.setAcessible(true);
 * field.set(calc, "def") 
 * field.setAcessible(false);
 * */