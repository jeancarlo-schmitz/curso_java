package entity.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import core.entity.DatabaseObject;

@Entity
@Table(name = "produtos")
public class Produto extends DatabaseObject {

	@Column(name = "prod_nome", length = 120, nullable = false)
	private String nome;
	
	@Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
	private Double preco;
	
	public Produto() {}
	
	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [ID=" + getId() + ", nome=" + nome + ", preco=" + preco + "]";
	}
}
