package oo.composicao.desafio;

public class MarketPlace {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("João");
		
		Produto p1 = new Produto("Caneta", 5.99);
		Produto p2 = new Produto("Caderno", 15.99);
		Produto p3 = new Produto("Lapis", 1.99);
		Produto p4 = new Produto("Garrafa de Agua", 9.99);
		
		Item item1 = new Item(p1, 10);
		Item item2 = new Item(p2, 2);
		Item item3 = new Item(p3, 3);
		Item item4 = new Item(p4, 1);
		
		Compra compra = new Compra();
		compra.itens.add(item1);
		compra.itens.add(item2);
		compra.itens.add(item3);
		compra.itens.add(item4);
		
		c1.compras.add(compra);

		System.out.println(c1.getValorCarrinho());

	}

}
