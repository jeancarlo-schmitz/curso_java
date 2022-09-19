package entity.basico.muitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import core.entity.DatabaseObject;

@Entity
@Table(name="filmes")
public class Filme extends DatabaseObject {
	
	private String nome;
	
	private Double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "atores_filmes",
			joinColumns=@JoinColumn(name="id_filme", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_ator", referencedColumnName = "id")
		)
	private List<Ator> atores = new ArrayList<>();
	
	public Filme() {}
	
	public Filme(String nome, Double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	public void adicionarAtor(Ator ator) {
		if(ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);
			if(!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", nota=" + nota + ", atores=" + atores + ", Id=" + getId() + "]";
	}
}
