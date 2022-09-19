package entity.basico.composicao;

import javax.persistence.Entity;
import javax.persistence.Table;

import core.entity.DatabaseObject;

@Entity
@Table(name="fornecedores")
public class Fornecedor extends DatabaseObject{
	
	private String nome;
	private Endereco endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
