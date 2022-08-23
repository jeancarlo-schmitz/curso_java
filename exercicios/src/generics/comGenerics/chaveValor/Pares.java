package generics.comGenerics.chaveValor;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pares<C, V> {

	Set<Par<C, V>> itens = new LinkedHashSet<>();
//	Set<Par<C, V>> itens = new TreeSet<>();
	
	public void adicionar(C chave, V valor) {
		if(chave == null) return;
		
		Par<C, V> novoPar = new Par<C, V> (chave, valor);
		
		if(itens.contains(novoPar)) {
			itens.remove(novoPar);
		}
		
		itens.add(novoPar);
	}
	
	public V getValor(C chave) {
		if(chave == null) return null;
		System.out.println(chave);
		Optional<Par<C, V>> optional =  itens.stream()
			.filter(par -> chave.equals(par.getChave()))
		    .findFirst();
		
		
		
		return optional.isPresent() ? optional.get().getValor() : null;
	}
	
	public C getChave(V valor) {
		if(valor == null) return null;
		
		Optional<Par<C, V>> optional =  itens.stream()
			.filter(par -> par.getValor().equals(valor))
		    .findFirst();
		
		return optional.isPresent() ? optional.get().getChave() : null;
	}
	
}
