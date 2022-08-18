package fundamentos.desafios;

public class TesteFor_meu {

	int a = 3;
	public static void main(String[] args) {
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					System.out.printf("[%d %d]", i, j);
//				}
//				System.out.println();
//			}

		String valor = "";
		for (;!valor.equalsIgnoreCase("#####");) {
			valor += "#";
			System.out.println(valor);
		}
		System.out.println("Fim");

		TesteFor_meu teste = new TesteFor_meu();
		System.out.println(teste.a);
//		String s = "teste";
//		for (char c: s.toCharArray()) {
//			System.out.println(c);
//		}
	}

}
