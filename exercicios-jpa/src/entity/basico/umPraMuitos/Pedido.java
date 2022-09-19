package entity.basico.umPraMuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import core.entity.DatabaseObject;

@Entity
public class Pedido extends DatabaseObject  {

	@Column(nullable = false)
	private Date data;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;
	
	public Pedido() {
		this(new Date());
	}
	
	public Pedido(Date data) {
		super();
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Pedido [data=" + data + ", Id=" + getId() + "]";
	}
}
