package br.com.academyflash.business;

import java.util.List;

import br.com.academyflash.dao.FuncionarioDao;
import br.com.academyflash.entidades.Funcionario;

public class FuncionarioBO {
	
	private static final FuncionarioDao FUNCIONARIO_DAO = new FuncionarioDao();
	
	public static void salvarFuncionario(Funcionario funcionario) throws ArgumentoInvalidoException {
		validar(funcionario);
		if(funcionario.getId() == 0){
			FUNCIONARIO_DAO.inserirFuncionario(funcionario);
		}else{
			FUNCIONARIO_DAO.atualizar(funcionario);
		}
	}
	
	public static List<Funcionario> listarTodos(){
		return FUNCIONARIO_DAO.listarTodos();
	}
	
	public static void validar(Funcionario funcionario) throws ArgumentoInvalidoException {
		Validacoes validacoes = new Validacoes();
		if(funcionario.getNome().isEmpty()) throw new ArgumentoInvalidoException("Campo nome vazio do funcionario");
		if(!validacoes.ValidarCPF(funcionario.getCpf())) throw new ArgumentoInvalidoException("Cpf do funcinario invalido.");
		if(funcionario.getRg() <= 0) throw new ArgumentoInvalidoException("Digite um RG.");
		if(funcionario.getGenero().isEmpty()) throw new ArgumentoInvalidoException("Campo genero vazio.");
		if(funcionario.getFuncao().isEmpty()) throw new ArgumentoInvalidoException("Campo funcao vazio");
		if(funcionario.getData_contrato().toString().isEmpty()) throw new ArgumentoInvalidoException("Data invalida");
		if(funcionario.getEndereco() == null) throw new ArgumentoInvalidoException("Funcionario sem endereco");
		if(funcionario.getContato() == null) throw new ArgumentoInvalidoException("Funcionario sem contato");
		ContatoBO.validarContato(funcionario.getContato());
		EnderecoBO.validarEndereco(funcionario.getEndereco());
		
	}

}
