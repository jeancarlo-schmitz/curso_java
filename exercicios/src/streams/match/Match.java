package Streams.match;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import Streams.Aluno;

public class Match {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Pedro", 3.9);
		Aluno a3 = new Aluno("João", 7.7);
		Aluno a4 = new Aluno("Maria", 6.5);
		Aluno a5 = new Aluno("Beca", 5.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		Predicate<Aluno> aprovados = a -> a.nota > 7;
		Predicate<Aluno> reprovados = aprovados.negate();
		
		System.out.println(alunos.stream().allMatch(aprovados));
		System.out.println(alunos.stream().anyMatch(aprovados));
		System.out.println(alunos.stream().noneMatch(reprovados));

	}

}
