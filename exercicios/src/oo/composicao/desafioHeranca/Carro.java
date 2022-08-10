package oo.composicao.desafioHeranca;

public class Carro {
	
	int velocidadeAceleracao;
	int velocidadeFrenagem;
	boolean carroLigado = false;
	int velocidadeCarro = 0;
	int rotacaoMotor = 2000;
	int velocidadeMaxima;
	
	public Carro() {
		this(5, 5, 200);
	}
	
	public Carro(int velocidadeAceleracao, int velocidadeFrenagem, int velocidadeMaxima) {
		this.velocidadeAceleracao = velocidadeAceleracao;
		this.velocidadeFrenagem = velocidadeFrenagem;
		this.velocidadeMaxima = velocidadeMaxima;
	}
	
	public void ligarDesligarCarro() {
		this.carroLigado = !carroLigado;
	}
	
	public void acelerarCarro() {
		if(this.carroLigado) {
			if(this.velocidadeCarro < this.velocidadeMaxima){
				this.velocidadeCarro += velocidadeAceleracao;
				this.rotacaoMotor *= 1.6;
			}else {
				this.velocidadeCarro = this.velocidadeMaxima;
				System.out.println("Carro com aceleração no maximo");
			}
		}
	}
	
	public void frearCarro() {
		if(this.carroLigado) {
			if(this.velocidadeCarro > 0){
				this.velocidadeCarro -= velocidadeFrenagem;
				this.rotacaoMotor /= 1.6;
			}else {
				this.velocidadeCarro = 0;
				System.out.println("Carro Está parado");
			}
		}
	}

	public int getVelocidadeAceleracao() {
		return velocidadeAceleracao;
	}

	public void setVelocidadeAceleracao(int velocidadeAceleracao) {
		this.velocidadeAceleracao = velocidadeAceleracao;
	}

	public int getVelocidadeFrenagem() {
		return velocidadeFrenagem;
	}

	public void setVelocidadeFrenagem(int velocidadeFrenagem) {
		this.velocidadeFrenagem = velocidadeFrenagem;
	}
	
	

	

}
