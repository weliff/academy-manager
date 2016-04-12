package br.com.academyflash.entidades;

public abstract class Pessoa {
	
	private int id;
	private String nome;
	private String cpf;
	private long rg;
	private String genero;
	private Contato contato;
	private Endereco endereco;
	
	protected Pessoa(){}
	
	protected Pessoa(int id, String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.genero = genero;
		this.contato = contato;
		this.endereco = endereco;
	}

	protected Pessoa(int id, String nome, String cpf, long rg, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.genero = genero;
	}
	protected Pessoa(String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.genero = genero;
		this.contato = contato;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [id=").append(id).append(", nome=").append(nome)
				.append(", cpf=").append(cpf).append(", rg=").append(rg)
				.append(", genero=").append(genero).append(", contato=")
				.append(contato).append(", endereco=").append(endereco);
		return builder.toString();
	}


}
