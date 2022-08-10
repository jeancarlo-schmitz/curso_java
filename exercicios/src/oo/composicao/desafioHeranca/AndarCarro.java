package oo.composicao.desafioHeranca;

public class AndarCarro {
	
	public static void main(String[] args) {
		Carro carroPopular = new Carro();
		Carro civic = new Civic();
		Carro ferrari = new Ferrari();
		
		System.out.println("Velocidade Aceleração Carro popular: " + carroPopular.velocidadeAceleracao);
		System.out.println("Velocidade Frenagem Carro popular: " + carroPopular.velocidadeFrenagem);
		System.out.println("Velocidade Maxima Carro Popular: " + carroPopular.velocidadeMaxima);
		System.out.println();
		
		System.out.println("Velocidade Aceleração Civic: " + civic.velocidadeAceleracao);
		System.out.println("Velocidade Frenagem Civic: " + civic.velocidadeFrenagem);
		System.out.println("Velocidade Maxima Civic: " + civic.velocidadeMaxima);
		System.out.println();
		
		System.out.println("Velocidade Aceleração Ferrari: " + ferrari.velocidadeAceleracao);
		System.out.println("Velocidade Frenagem Ferrari: " + ferrari.velocidadeFrenagem);
		System.out.println("Velocidade Maxima Ferrari: " + ferrari.velocidadeMaxima);
		System.out.println();
		
		carroPopular.ligarDesligarCarro();
		carroPopular.acelerarCarro();
		carroPopular.frearCarro();
		System.out.println("Velocidade Atual:" + carroPopular.velocidadeCarro);
		System.out.println();
		
		civic.ligarDesligarCarro();
		civic.acelerarCarro();
		System.out.println("Velocidade Atual:" + civic.velocidadeCarro);
		System.out.println();
		
		ferrari.ligarDesligarCarro();
		ferrari.acelerarCarro();
		ferrari.acelerarCarro();
		ferrari.acelerarCarro();
		System.out.println("Velocidade Atual:" + ferrari.velocidadeCarro);
		System.out.println();
		
		
	}
}
