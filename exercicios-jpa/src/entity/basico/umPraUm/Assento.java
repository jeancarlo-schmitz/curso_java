package entity.basico.umPraUm;

import javax.persistence.Entity;
import javax.persistence.Table;

import core.entity.DatabaseObject;

@Entity
@Table(name="assentos")
public class Assento extends DatabaseObject {

	private String nome;
	
	public Assento() {}
	
	public Assento(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Assento [nome=" + nome + ", Id()=" + getId() + "]";
	}
}
