package br.com.academyflash.dao;

import java.util.Date;

import br.com.academyflash.business.AlunoBO;
import br.com.academyflash.business.ArgumentoInvalidoException;
import br.com.academyflash.business.FuncionarioBO;
import br.com.academyflash.business.LoginBO;
import br.com.academyflash.entidades.Aluno;
import br.com.academyflash.entidades.Contato;
import br.com.academyflash.entidades.Endereco;
import br.com.academyflash.entidades.Funcionario;
import br.com.academyflash.entidades.Login;

public class Teste {
	
	public static void main(String[] args) {
		
		
//		Endereco endereco = new Endereco("rua tal", 123, "taltal", "centro", "quixada", "63900-000");
//		Contato contato = new Contato("weliff.14@gmail.com", "(88)9999-9999", "(88)9999-9999");
//		Funcionario funcionario = new Funcionario("weliff", "062.937.163-61", 1234, "M", contato, endereco, "adm", new Date());
//		Login login = new Login("weliff", "1234", 1, funcionario);
		
//		Aluno a = new Aluno("joao", "111.111.111-11", 12312, "M", contato, endereco, funcionario.getNome(), "Tarde", new Date());
//		for (int i = 0; i < 100; i++) {
//			AlunoBO.salvar(a);
//			
//		}
//		try {
//			LoginBO.salvarLogin(login);
//			FuncionarioBO.salvarFuncionario(funcionario);
//		} catch (ArgumentoInvalidoException e) {
//			e.printStackTrace();
//		}
		
//		for (Login login2 : LoginBO.listarTodos()) {
//			System.out.println(login2);
//		}
		
//		for (Funcionario fun : FuncionarioBO.listarTodos()) {
//			System.out.println(fun);
//		}
		
		for (Aluno alunos : AlunoBO.listarTodos()) {
			System.out.println(alunos);
		}
		
	}

}
