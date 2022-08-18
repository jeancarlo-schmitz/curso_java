package streams.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import streams.Aluno;

public class Filter {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Pedro", 3.9);
		Aluno a3 = new Aluno("João", 7.7);
		Aluno a4 = new Aluno("Maria", 6.5);
		Aluno a5 = new Aluno("Beca", 5.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		Predicate<Aluno> aprovados = a -> a.nota > 7;
		Function<Aluno, String> saudacaoAprovados = a -> "Parabens, " + a.nome + " Você foi aprovado(a)!!";
		
		alunos.stream().filter(aprovados).map(saudacaoAprovados).forEach(System.out::println);

	}

}
