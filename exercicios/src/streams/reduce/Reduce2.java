package Streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import Streams.Aluno;
import Streams.Media;

public class Reduce2 {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Pedro", 3.9);
		Aluno a3 = new Aluno("João", 7.7);
		Aluno a4 = new Aluno("Maria", 6.5);
		Aluno a5 = new Aluno("Beca", 5.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		Predicate<Aluno> aprovados = a -> a.nota > 7;
		Function<Aluno, Double> notas = a -> a.nota;
		BinaryOperator<Double> soma = (a, b) -> a + b;
		
		BiFunction<Media, Double, Media> calcularMedia = (media, valor) -> media.adicionar(valor);
		
		BinaryOperator<Media> combinarMedia = (m1, m2) -> Media.combinar(m1, m2);
		
		//alunos.stream().filter(aprovados).map(notas).reduce(soma).ifPresent(System.out::println);
		
		/*Pegar a média*/
		Media resultado = alunos.stream()
				.filter(aprovados)
				.map(notas)
				.reduce(new Media(), calcularMedia, combinarMedia);
		
		System.out.println(resultado.getValor());
	}
}
