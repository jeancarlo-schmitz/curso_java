package oo.composicao.muitosParaMuitos;

import java.util.ArrayList;
import java.util.List;


public class Aluno {
	
	final String nome;
	final List<Curso> cursos = new ArrayList<>();
	
	Aluno(String nome){
		this.nome = nome;
	}
	
	Curso doEncontrarCurso(String nome) {
		for(Curso curso: this.cursos) {
			if(curso.nome.equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		
		return null;
	}

	void adicionarCurso(Curso curso) {
		this.cursos.add(curso);
		curso.alunos.add(this);
	}
	
	public String toString() {
		return this.nome;
	}
}
