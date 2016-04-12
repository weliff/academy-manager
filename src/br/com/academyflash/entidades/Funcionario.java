package br.com.academyflash.entidades;

import java.util.Date;

public class Funcionario extends Pessoa{
	
	private String funcao;
	private Date data_contrato;
	
	public Funcionario(){}
	
	public Funcionario(int id, String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco, String funcao,
			Date data_contrato) {
		super(id, nome, cpf, rg, genero, contato, endereco);
		this.funcao = funcao;
		this.data_contrato = data_contrato;
	}
	public Funcionario(String nome, String cpf, long rg, String genero,
			Contato contato, Endereco endereco, String funcao, Date data_contrato
			) {
		super(nome, cpf, rg, genero, contato, endereco);
		this.funcao = funcao;
		this.data_contrato = data_contrato;
	}

	public Funcionario(int id, String nome, String cpf, long rg, String genero,
			String funcao, Date data_contrato) {
		super(id, nome, cpf, rg, genero);
		this.funcao = funcao;
		this.data_contrato = data_contrato;
	}


	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Date getData_contrato() {
		return data_contrato;
	}

	public void setData_contrato(Date data_contrato) {
		this.data_contrato = data_contrato;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("Funcionario [funcao=").append(funcao)
				.append(", data_contrato=").append(data_contrato).append("]");
		return builder.toString();
	}

}