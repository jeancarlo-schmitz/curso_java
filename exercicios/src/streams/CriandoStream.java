package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class CriandoStream {

	public static void main(String[] args) {
		Consumer<String> print = System.out::print;
		Consumer<Object> println= System.out::println;
		
		Stream<String> langs = Stream.of("Java, ", "PHP, ", "JavaScripto\n");
		langs.forEach(print);
		
		String[] maisLangs = {"Ruby, ", "Kotlin, ", "Lua\n"};
		Stream.of(maisLangs).forEach(print);
		List<String> outrasLangs =  Arrays.asList("GoLang, ", "C#, ", "Python\n");
		outrasLangs.stream().forEach(print);
		
		Stream.iterate(0, n -> n +1).forEach(println);

	}

}
