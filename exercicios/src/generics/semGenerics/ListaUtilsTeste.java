package generics.semGenerics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilsTeste {
	public static void main(String[] args) {

		List<String> langs = Arrays.asList("PHP", "JS", "JAVA", "C++");
		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);
		
		String ultimaLinguagem1 = (String) ListaUtils.getUltimoIndiceArray1(langs);
		Integer ultimaNumero1 = (Integer) ListaUtils.getUltimoIndiceArray1(numeros);
		
		System.out.println(ultimaLinguagem1);
		System.out.println(ultimaNumero1);
		
		String ultimaLinguagem2 =  ListaUtils.getUltimoIndiceArray2(langs);
		Integer ultimaNumero2 = ListaUtils.<Integer>getUltimoIndiceArray2(numeros);/*Podem amarrar pelo tipo <Integer> se quiser, mas não é necessário*/
		
		System.out.println(ultimaLinguagem2);
		System.out.println(ultimaNumero2);
	}
}
