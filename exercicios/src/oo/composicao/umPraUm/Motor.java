package oo.composicao.umPraUm;

public class Motor {

	double fatorInjecao =1;
	boolean ligado = false;
	
	int giros() {
		if(!ligado) {
			return 0;
		}
		
		return (int) Math.round(fatorInjecao * 3000);
	}
	
	
}
