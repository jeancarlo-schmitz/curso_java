package arrays;

public class Exercicios {

	public static void main(String[] args) {

		double notasAlunasA[] = new double[4];
		notasAlunasA[0] = 7.8;
		notasAlunasA[1] = 6.6;
		notasAlunasA[2] = 9;
		notasAlunasA[3] = 3.9;

		double totalNotasAlunos = 0;
		for (int i = 0; i < notasAlunasA.length; i++) {
			totalNotasAlunos += notasAlunasA[i];
		}

		System.out.println(totalNotasAlunos / notasAlunasA.length);

		double notasAlunosB[] = { 5.8, 7.3, 5.5, 9.7, 3.5 };

		double totalNotasAlunosB = 0;
		for (double nota : notasAlunosB) {
			System.out.println(nota);
			totalNotasAlunosB += nota;
		}
		System.out.println(totalNotasAlunosB / notasAlunosB.length);

		double notasAlunosC[][] = new double[2][2];
		notasAlunosC[0][0] =5 ;
		notasAlunosC[0][1] = 6;
		notasAlunosC[1][0] = 6;
		notasAlunosC[1][1] = 7;
		double totalNotasAlunosC = 0;
		for (double alunos[] : notasAlunosC) {
			for (double nota : alunos) {
				System.out.println(nota);
				totalNotasAlunosC += nota;
			}
		}
		System.out.println(totalNotasAlunosC);

	}

}
