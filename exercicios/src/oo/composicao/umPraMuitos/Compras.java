package oo.composicao.umPraMuitos;

import java.util.ArrayList;

public class Compras {

	String cliente;
	ArrayList<Item> itens = new ArrayList<>();
	
	double getTotalValue() {
		double total = 0;
		
		for(Item item: itens) {
			total += item.preco * item.quantidade;
		}
		
		return total;
	}
}
