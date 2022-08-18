package streams.desafio;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class DesafioMap {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Consumer<Object> print = System.out::println;
		
		Function<Integer, String> toBinary = valor -> Integer.toBinaryString(valor);
		Function<String, String> invertBinary = valor -> new StringBuilder(valor).reverse().toString();
		Function<String, Integer> toInteger = valor -> Integer.parseInt(valor, 2);
		
		lista.stream()
				.map(toBinary)
				.map(invertBinary)
				.map(toInteger)
				.forEach(print);
	}

}
