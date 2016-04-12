package br.com.academyflash.business;

import java.util.List;

import br.com.academyflash.dao.LoginDao;
import br.com.academyflash.entidades.Login;

public class LoginBO {
	
	private static final LoginDao LOGIN_DAO = new LoginDao();
	
	public static void salvarLogin(Login login) throws ArgumentoInvalidoException{
		validar(login);
		LOGIN_DAO.inserir(login);
	}
	
	public static void atualizarLogin(Login login) throws ArgumentoInvalidoException{
		validar(login);
		LOGIN_DAO.atualizar(login);
		
	}
	
	public static void excluir(Login login){
		LOGIN_DAO.excluir(login);
	}
	
	public static List<Login> listarTodos(){
		return LOGIN_DAO.listarTodos();
	}

	public static void validar(Login login) throws ArgumentoInvalidoException{
		if(login.getUsuario().isEmpty()) throw new ArgumentoInvalidoException("Campo de usuario vazio.");
		if(login.getSenha().isEmpty()) throw new ArgumentoInvalidoException("Campo de senha vazio.");
		if(login.getNivel() < 1 || login.getNivel() > 3) throw new ArgumentoInvalidoException("Campo de nivel invalido.");
		
	}
	

}
