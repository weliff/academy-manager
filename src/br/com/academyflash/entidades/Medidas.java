package br.com.academyflash.entidades;

import java.util.Date;

public class Medidas {
	
	private int id;
	private Date dataMedida;
	private Aluno aluno;
	private double bracoEsquerdo;
	private double bracoDireito;
	private double busto;
	private double cintura;
	private double circuloAbdominal;
	private double quadril;
	private double coxaEsquerda;
	private double coxaDireita;
	private double panturilhaEsquerda;
	private double panturilhaDireita;
	
	public Medidas(){}

	public Medidas(int id, Date dataMedida, Aluno aluno, double bracoEsquerdo,
			double bracoDireito, double busto, double cintura,
			double circuloAbdominal, double quadril, double coxaEsquerda,
			double coxaDireita, double panturilhaEsquerda,
			double panturilhaDireita) {
		super();
		this.id = id;
		this.dataMedida = dataMedida;
		this.aluno = aluno;
		this.bracoEsquerdo = bracoEsquerdo;
		this.bracoDireito = bracoDireito;
		this.busto = busto;
		this.cintura = cintura;
		this.circuloAbdominal = circuloAbdominal;
		this.quadril = quadril;
		this.coxaEsquerda = coxaEsquerda;
		this.coxaDireita = coxaDireita;
		this.panturilhaEsquerda = panturilhaEsquerda;
		this.panturilhaDireita = panturilhaDireita;
	}

	public Medidas(Date dataMedida, Aluno aluno, double bracoEsquerdo,
			double bracoDireito, double busto, double cintura,
			double circuloAbdominal, double quadril, double coxaEsquerda,
			double coxaDireita, double panturilhaEsquerda,
			double panturilhaDireita) {
		super();
		this.dataMedida = dataMedida;
		this.aluno = aluno;
		this.bracoEsquerdo = bracoEsquerdo;
		this.bracoDireito = bracoDireito;
		this.busto = busto;
		this.cintura = cintura;
		this.circuloAbdominal = circuloAbdominal;
		this.quadril = quadril;
		this.coxaEsquerda = coxaEsquerda;
		this.coxaDireita = coxaDireita;
		this.panturilhaEsquerda = panturilhaEsquerda;
		this.panturilhaDireita = panturilhaDireita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataMedida() {
		return dataMedida;
	}

	public void setDataMedida(Date dataMedida) {
		this.dataMedida = dataMedida;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public double getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(double bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public double getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(double bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public double getBusto() {
		return busto;
	}

	public void setBusto(double busto) {
		this.busto = busto;
	}

	public double getCintura() {
		return cintura;
	}

	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	public double getCirculoAbdominal() {
		return circuloAbdominal;
	}

	public void setCirculoAbdominal(double circuloAbdominal) {
		this.circuloAbdominal = circuloAbdominal;
	}

	public double getQuadril() {
		return quadril;
	}

	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}

	public double getCoxaEsquerda() {
		return coxaEsquerda;
	}

	public void setCoxaEsquerda(double coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

	public double getCoxaDireita() {
		return coxaDireita;
	}

	public void setCoxaDireita(double coxaDireita) {
		this.coxaDireita = coxaDireita;
	}

	public double getPanturilhaEsquerda() {
		return panturilhaEsquerda;
	}

	public void setPanturilhaEsquerda(double panturilhaEsquerda) {
		this.panturilhaEsquerda = panturilhaEsquerda;
	}

	public double getPanturilhaDireita() {
		return panturilhaDireita;
	}

	public void setPanturilhaDireita(double panturilhaDireita) {
		this.panturilhaDireita = panturilhaDireita;
	}

}
