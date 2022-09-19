package entity.basico.muitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import core.entity.DatabaseObject;

@Entity
public class Tio extends DatabaseObject {

	private String nome;
	
	@ManyToMany
	private List<Sobrinho> sobrinhos = new ArrayList<>();

	public Tio() {}
	
	public Tio(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Sobrinho> getSobrinhos() {
		return sobrinhos;
	}

	public void setSobrinhos(List<Sobrinho> sobrinhos) {
		this.sobrinhos = sobrinhos;
	}

	@Override
	public String toString() {
		return "Tio [nome=" + nome + ", sobrinhos=" + sobrinhos + ", Id=" + getId() + "]";
	}
	
	
}
