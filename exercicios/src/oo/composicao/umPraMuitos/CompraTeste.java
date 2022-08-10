package oo.composicao.umPraMuitos;

public class CompraTeste {

	public static void main(String[] args) {
		
		Compras compra = new Compras();
		
		compra.cliente = "Pedrinho";
		compra.itens.add(new Item("Caneta", 10, 3.70));
		compra.itens.add(new Item("Caderno", 3, 15.70));
		compra.itens.add(new Item("Borracha", 10, 0.70));
		
		System.out.println(compra.itens.size());
		System.out.println(compra.getTotalValue());

	}

}
