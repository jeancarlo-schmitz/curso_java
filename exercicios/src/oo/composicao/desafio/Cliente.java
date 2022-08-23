package oo.composicao.desafio;

import java.util.ArrayList;

public class Cliente {

	String nome;
	ArrayList<Compra> compras = new ArrayList<>();
	
	
	Cliente(String nome){
		this.nome = nome;
	}
	
	double getValorCarrinho() {
		double valorCarrinho = 0;
		
		for(Compra compra: compras) {
			for(Item item: compra.itens) {
				valorCarrinho += item.produto.valor * item.qtdItens;
			}
		}
		return valorCarrinho;
	}
}
