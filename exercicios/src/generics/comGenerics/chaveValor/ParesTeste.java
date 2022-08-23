package generics.comGenerics.chaveValor;

public class ParesTeste {

	public static void main(String[] args) {
		
		Pares<Integer, String> passaramNoConcurso = new Pares<>();
		
		passaramNoConcurso.adicionar(1, "Mária");
		passaramNoConcurso.adicionar(2, "Pedro");
		passaramNoConcurso.adicionar(3, "João");
		passaramNoConcurso.adicionar(4, "Jean");
		passaramNoConcurso.adicionar(5, "Bruna");
		passaramNoConcurso.adicionar(2, "Xablau");
		
		System.out.println(passaramNoConcurso.getValor(1));
		System.out.println(passaramNoConcurso.getValor(2));
		System.out.println(passaramNoConcurso.getChave("Jean"));

	}

}
