package entity.basico.umPraUm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import core.entity.DatabaseObject;

@Entity
@Table(name="clientes")
public class Cliente extends DatabaseObject {

	private String nome;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_assento", unique = true)
	private Assento assento;

	public Cliente() {}
	
	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", assento=" + assento + ", Id=" + getId() + "]";
	}

}
