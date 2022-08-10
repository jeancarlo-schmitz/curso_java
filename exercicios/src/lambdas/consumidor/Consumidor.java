package lambdas.consumidor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


import lambdas.Produto;

public class Consumidor {
    public static void main(String[] args) {
        Consumer<Produto> imprimirNome = prod -> System.out.println(prod.nome);

        Produto p1 = new Produto("Caneta", 5.95, 0.02);
        imprimirNome.accept(p1);

        Produto p2 = new Produto("Caderno", 12.95, 0.1);
        Produto p3 = new Produto("Notebook", 1200.95, 0.2);
        Produto p4 = new Produto("Lapis", 4.95, 0.12);
        Produto p5 = new Produto("Borracha", 6.95, 0.22);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
        produtos.forEach(imprimirNome);
        produtos.forEach(p -> System.out.println(p.preco));
        produtos.forEach(System.out::println);
    }
}
