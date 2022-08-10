package excecao;

public class ChecadaNaoChecada {

	public static void main(String[] args) {

		try {
			geraErro1();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			geraErro2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//NÃO checada ou não verificada
	public static void geraErro1() {
		throw new RuntimeException("Erro bem Legal #1!!");
	}	
	
	//Excepetion checada ou verificada
	public static void geraErro2() throws Exception {
		throw new Exception("Erro bem Legal #2!!");
	}
}
