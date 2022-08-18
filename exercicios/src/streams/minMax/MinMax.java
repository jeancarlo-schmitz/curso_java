package streams.minMax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import streams.Aluno;

public class MinMax {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Pedro", 3.9);
		Aluno a3 = new Aluno("João", 7.7);
		Aluno a4 = new Aluno("Maria", 6.5);
		Aluno a5 = new Aluno("Beca", 5.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5);
		
		Comparator<Aluno> nota = (aluno1, aluno2) -> {
			if(aluno1.nota > aluno2.nota) return 1;
			if(aluno1.nota < aluno2.nota) return -1;
			return 0;
		};
		
		System.out.println(alunos.stream().max(nota));
		System.out.println(alunos.stream().min(nota));

	}

}
