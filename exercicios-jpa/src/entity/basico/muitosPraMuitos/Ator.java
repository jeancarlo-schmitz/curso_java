package entity.basico.muitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import core.entity.DatabaseObject;

@Entity
@Table(name="atores")
public class Ator extends DatabaseObject {
	
	private String nome;
	
	@ManyToMany(mappedBy = "atores", cascade = CascadeType.PERSIST)
	private List<Filme> filmes = new ArrayList<>();
	
	public Ator() {}

	public Ator(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public String toString() {
		return "Ator [nome=" + nome + ", filmes=" + filmes + ", Id=" + getId() + "]";
	}
	
}
