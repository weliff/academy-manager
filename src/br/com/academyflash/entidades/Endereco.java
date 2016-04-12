package br.com.academyflash.entidades;

public class Endereco {
	
	private int id;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	
	public Endereco(int id, String endereco, int numero, String complemento,
			String bairro, String cidade, String cep) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	public Endereco(String endereco, int numero, String complemento,
			String bairro, String cidade, String cep) {
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [id=").append(id).append(", endereco=")
				.append(endereco).append(", numero=").append(numero)
				.append(", complemento=").append(complemento)
				.append(", bairro=").append(bairro).append(", cidade=")
				.append(cidade).append(", cep=").append(cep).append("]");
		return builder.toString();
	}
}
