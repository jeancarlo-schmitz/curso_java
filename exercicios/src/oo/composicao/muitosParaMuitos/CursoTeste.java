package oo.composicao.muitosParaMuitos;

public class CursoTeste {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno("João");
		Aluno aluno2 = new Aluno("Maria");
		Aluno aluno3 = new Aluno("Pedro");
		
		Curso curso1 = new Curso("Java Completo");
		Curso curso2 = new Curso("Python Completo");
		Curso curso3 = new Curso("React Native");
		
		curso1.adicionarAlunos(aluno1);
		curso1.adicionarAlunos(aluno2);
		
		curso2.adicionarAlunos(aluno3);
		curso2.adicionarAlunos(aluno1);
		
		aluno1.adicionarCurso(curso3);
		aluno2.adicionarCurso(curso3);
		aluno3.adicionarCurso(curso3);
		
		Curso cursoEncontrado = aluno1.doEncontrarCurso("Java Completo");
		if(cursoEncontrado != null) {
			System.out.println(cursoEncontrado.nome);
			System.out.println(cursoEncontrado.alunos.toString());
		}

	}

}
