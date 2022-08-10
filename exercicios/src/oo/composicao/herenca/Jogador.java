package oo.composicao.herenca;

public class Jogador {
	
	int vida = 100;
	int posX = 0;
	int posY = 0;
	
	public boolean atacar(Jogador oponente) {
		int deltaX = Math.abs(posX - oponente.posX);
		int deltaY = Math.abs(posY - oponente.posY);
		
		if((deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 0)) {
			oponente.vida -= 10;
			return true;
		}
		return false;
	}
	
	public void andar(Direcao direcao) {
		if(direcao == Direcao.NORTE) {
			posY--;
		}else if(direcao == Direcao.LESTE) {
			posX++;
		}else if(direcao == Direcao.SUL) {
			posY++;
		}else if(direcao == Direcao.OESTE) {
			posX--;
		}
	}

}
