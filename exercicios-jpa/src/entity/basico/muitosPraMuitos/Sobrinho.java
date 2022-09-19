package entity.basico.muitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import core.entity.DatabaseObject;

@Entity
public class Sobrinho extends DatabaseObject {

	private String nome;
	
	@ManyToMany(mappedBy = "sobrinhos")
	private List<Tio> tios = new ArrayList<>();

	public Sobrinho() {}
	
	public Sobrinho(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tio> getTios() {
		return tios;
	}

	public void setTios(List<Tio> tios) {
		this.tios = tios;
	}

	@Override
	public String toString() {
		return "Sobrinho [nome=" + nome + ", tios=" + tios + ", Id=" + getId() + "]";
	}
	
}
