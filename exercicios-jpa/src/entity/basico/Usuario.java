package entity.basico;

import javax.persistence.Entity;

import core.entity.DatabaseObject;

@Entity
public class Usuario extends DatabaseObject {
	
	private String nome;
	
	private String email;
	
	public Usuario() {}
	
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [ID= "+ getId() + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
}
