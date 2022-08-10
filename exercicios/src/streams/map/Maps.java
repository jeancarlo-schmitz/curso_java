package Streams.map;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Maps {

	public static void main(String[] args) {
		Consumer<String> print = System.out::print;
		List<String> marcas = Arrays.asList("Bmw, ", "Audi, ", "Honda\n");
		marcas.stream().map(String::toUpperCase).forEach(print);

	}

}
