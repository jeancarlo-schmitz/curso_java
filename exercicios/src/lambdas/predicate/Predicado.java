package lambdas.predicate;

import java.util.function.Predicate;

import lambdas.Produto;

public class Predicado {
    public static void main(String[] args) {
        Predicate<Produto> isCaro = prod -> (prod.preco * (1- prod.desconto)) > 750;

        Produto produto = new Produto("Caneta", 2500, 0.15);
        System.out.println(isCaro.test(produto));
    }
    
}