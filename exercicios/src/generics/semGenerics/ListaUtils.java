package generics.semGenerics;

import java.util.List;

public class ListaUtils {

	public static Object getUltimoIndiceArray1(List<?> lista) {
		return lista.get(lista.size() -1);
	}
	
	public static <T> T getUltimoIndiceArray2(List<T> lista) {
		return lista.get(lista.size() -1);
	}
	
	/*Dá pra fazer essas loucuras tbm kkkk*/
	public static <A, B, C> C getUltimoIndiceArray2(A paramA, B paramB) {
		C teste = null;
		return teste;
	}
}
