package br.com.academyflash.entidades;

public class Login {
	

	private int id;
	private String usuario;
	private String senha;
	private int nivel;
	
	public Login(String usuario, String senha, int nivel) {
		this.usuario = usuario;
		this.senha = senha;
		this.nivel = nivel;
	}
        
        public Login(int id, String usuario, String senha, int nivel) {
                this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [id=").append(id).append(", usuario=")
				.append(usuario).append(", senha=").append(senha)
				.append(", nivel=").append(nivel).append(", funcionario=")
				.append("]");
		return builder.toString();
	}

	
}
