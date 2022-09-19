package entity.basico.composicao;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String logradouro;
	private String complemento;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	public Endereco(String logradouro, String complemento) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
