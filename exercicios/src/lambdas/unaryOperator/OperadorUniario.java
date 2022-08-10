package lambdas.unaryOperator;

import java.util.function.UnaryOperator;

public class OperadorUniario {
    public static void main(String[] args) {
        UnaryOperator<Integer> maisDois = n -> n + 2;
        UnaryOperator<Integer> vezesDois = n -> n * 2;
        UnaryOperator<Integer> aoQuadrado = n -> n * n;

        int numero1 = maisDois.andThen(vezesDois).andThen(aoQuadrado).apply(0);
        int numero2 = aoQuadrado.compose(vezesDois).compose(maisDois).apply(0);

        System.out.println(numero1);
        System.out.println(numero2);
        
    }
    
}

