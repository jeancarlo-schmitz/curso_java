package streams.others;

import java.util.Arrays;
import java.util.List;

import streams.Aluno;

public class Outros {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Pedro", 3.9);
		Aluno a3 = new Aluno("João", 7.7);
		Aluno a4 = new Aluno("Maria", 6.5);
		Aluno a5 = new Aluno("Beca", 5.8);
		Aluno a6 = new Aluno("Ana", 7.8);
		Aluno a7 = new Aluno("Luca", 5.9);
		Aluno a8 = new Aluno("Ernesto", 7.7);
		Aluno a9 = new Aluno("Maria", 6.5);
		Aluno a10 = new Aluno("Bruna", 5.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
		
		System.out.println("Distinct...");
		alunos.stream()
				.distinct()
				.forEach(System.out::println);
		
		System.out.println("\nSkip/Limit");
		alunos.stream()
				.distinct()
				.skip(2)
				.limit(2)
				.forEach(System.out::println);
		
		System.out.println("\nTakeWhile");
		alunos.stream()
				.distinct()
				.takeWhile(a -> a.nota >= 7)
				.forEach(System.out::println);

	}

}
