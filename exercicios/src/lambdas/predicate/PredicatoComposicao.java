package lambdas.predicate;

import java.util.function.Predicate;

public class PredicatoComposicao {
    public static void main(String[] args) {
        Predicate<Integer> parOuImpar = numero -> numero % 2 == 0;
        Predicate<Integer> numeroTresDigitos = numero -> numero >= 100 && numero <= 999;
        
        System.out.println(parOuImpar.and(numeroTresDigitos).test(32));
        System.out.println(parOuImpar.or(numeroTresDigitos).test(323));
    }
}
