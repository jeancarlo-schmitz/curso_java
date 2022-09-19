package entity.basico.umPraMuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.entity.DatabaseObject;
import entity.basico.Produto;

@Entity
@Table(name = "item_pedido")
public class ItemPedido extends DatabaseObject {

	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Produto produto;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private Double preco;
	
	public ItemPedido() {}
	
	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
		super();
		setPedido(pedido);
		setProduto(produto);
		setQuantidade(quantidade);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(produto != null && preco == null) {
			setPreco(produto.getPreco());
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ItemPedido [pedido=" + pedido + ", produto=" + produto + ", quantidade=" + quantidade + ", preco="
				+ preco + ", Id=" + getId() + "]";
	}
}
