package br.com.academyflash.entidades;

public class Contato {
	
	private int id;
	private String email;
	private String telefone;
	private String celular;
	
	public Contato(int id, String email, String telefone, String celular) {
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}
	public Contato(String email, String telefone, String celular) {
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [id=").append(id).append(", email=")
				.append(email).append(", telefone=").append(telefone)
				.append(", celular=").append(celular).append("]");
		return builder.toString();
	}

}
