package streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {
	
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9);
		
		BinaryOperator<Integer> soma = (ac, num) -> ac + num;
		
		lista.stream().reduce(soma).ifPresent(System.out::println);
		lista.stream().reduce(100, soma).describeConstable().ifPresent(System.out::println);
		
		
	}

}
