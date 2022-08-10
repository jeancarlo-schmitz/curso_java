package lambdas.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {
    
    public static void main(String[] args) {
        //não recebe nada e retorna alguma coisa

        Supplier<List<String>> listaNomes = () -> Arrays.asList("Pedro", "Paulo", "Luiz", "Fernando");
        
        System.out.println(listaNomes.get());
    }
}
