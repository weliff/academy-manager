package br.com.academyflash.business;

import java.util.List;

import br.com.academyflash.dao.AlunoDao;
import br.com.academyflash.entidades.Aluno;

public class AlunoBO {
	
	private static final AlunoDao ALUNO_DAO = new AlunoDao();
	
	public static void salvar(Aluno aluno) throws ArgumentoInvalidoException{
		validar(aluno);
		if(aluno.getId() == 0){
			ALUNO_DAO.inserir(aluno);
		}else{
			ALUNO_DAO.atualizar(aluno);
		}
	}
	
	public static void validar(Aluno aluno) throws ArgumentoInvalidoException {
		
		Validacoes validacoes = new Validacoes();
		if(aluno.getNome().isEmpty()) throw new ArgumentoInvalidoException("Campo nome vazio do aluno");
		if(!validacoes.ValidarCPF(aluno.getCpf())) throw new ArgumentoInvalidoException("Cpf do aluno invalido.");
		if(aluno.getRg() < 0) throw new ArgumentoInvalidoException("Campo nome vázio do aluno");
		if(aluno.getGenero().isEmpty()) throw new ArgumentoInvalidoException("Campo genero vazio.");
		if(aluno.getNomeDoInstrutor().isEmpty()) throw new ArgumentoInvalidoException("Aluno sem instrutor.");
		if(aluno.getTurno().isEmpty()) throw new ArgumentoInvalidoException("Selecione o turno do aluno.");
		if(aluno.getDataDeInscricao().toString().isEmpty()) throw new ArgumentoInvalidoException("Data invalida");
		if(aluno.getFuncionario() == null) throw new ArgumentoInvalidoException("Instrutor invï¿½lido.");
		if(aluno.getEndereco() == null) throw new ArgumentoInvalidoException("Aluno sem endereco");
		if(aluno.getContato() == null) throw new ArgumentoInvalidoException("Aluno sem contato");
		ContatoBO.validarContato(aluno.getContato());
		EnderecoBO.validarEndereco(aluno.getEndereco());
	}
	
	public static List<Aluno> listarTodos(){
		return ALUNO_DAO.listarTodos();
	}

}
