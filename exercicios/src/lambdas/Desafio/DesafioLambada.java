package lambdas.Desafio;

import java.text.DecimalFormat;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import lambdas.Produto;

public class DesafioLambada {
    public static void main(String[] args) {
        Produto produto = new Produto("NoteBook", 3235.89, 0.13);
        
        BinaryOperator<Double> precoComDesconto = (preco, desconto) -> preco * (1 - desconto);
        UnaryOperator<Double> precoComImposto = preco -> preco >= 2500 ? preco * 1.085 : preco;
        UnaryOperator<Double> valorFrete = preco -> preco >= 3000 ? preco + 100 :  preco + 50;
        Function<Double, String> valorFormatado = valor -> {DecimalFormat df = new DecimalFormat("R$ #,###.00"); return df.format(valor);};

        String valorFinal = precoComDesconto
                    .andThen(precoComImposto)
                    .andThen(valorFrete)
                    .andThen(valorFormatado)
                    .apply(produto.preco, produto.desconto);

        System.out.println(valorFinal);
    }
}
