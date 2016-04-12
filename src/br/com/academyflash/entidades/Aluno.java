package br.com.academyflash.entidades;

import java.util.Date;

public class Aluno extends Pessoa{
	
	private String nomeDoInstrutor;
	private String turno;
	private Date dataDeInscricao;
	private Funcionario funcionario;
	public Aluno() {}
	public Aluno(int id, String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco, String nomeDoInstrutor,
			String turno, Date dataDeInscricao, Funcionario funcionario) {
		super(id, nome, cpf, rg, genero, contato, endereco);
		this.nomeDoInstrutor = nomeDoInstrutor;
		this.turno = turno;
		this.dataDeInscricao = dataDeInscricao;
		this.funcionario = funcionario;
	}
	public Aluno(String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco, String nomeDoInstrutor,
			String turno, Date dataDeInscricao, Funcionario funcionario) {
		super(nome, cpf, rg, genero, contato, endereco);
		this.nomeDoInstrutor = nomeDoInstrutor;
		this.turno = turno;
		this.dataDeInscricao = dataDeInscricao;
		this.funcionario = funcionario;
	}
	public Aluno(int id, String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco, String nomeDoInstrutor,
			String turno, Date dataDeInscricao) {
		super(id, nome, cpf, rg, genero, contato, endereco);
		this.nomeDoInstrutor = nomeDoInstrutor;
		this.turno = turno;
		this.dataDeInscricao = dataDeInscricao;
	}
	public Aluno(int id, String nome, String cpf, long rg, String genero,
			String nomeDoInstrutor, String turno, Date dataDeInscricao) {
		super(id, nome, cpf, rg, genero);
		this.nomeDoInstrutor = nomeDoInstrutor;
		this.turno = turno;
		this.dataDeInscricao = dataDeInscricao;
	}
	public String getNomeDoInstrutor() {
		return nomeDoInstrutor;
	}
	public void setNomeDoInstrutor(String nomeDoInstrutor) {
		this.nomeDoInstrutor = nomeDoInstrutor;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Date getDataDeInscricao() {
		return dataDeInscricao;
	}
	public void setDataDeInscricao(Date dataDeInscricao) {
		this.dataDeInscricao = dataDeInscricao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("Aluno [nomeDoInstrutor=").append(nomeDoInstrutor)
				.append(", turno=").append(turno).append(", dataDeInscricao=")
				.append(dataDeInscricao).append(", funcionario=")
				.append(funcionario).append("]");
		return builder.toString();
	}

}
