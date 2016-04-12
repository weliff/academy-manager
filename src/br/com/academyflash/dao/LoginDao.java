package br.com.academyflash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academyflash.entidades.Funcionario;
import br.com.academyflash.entidades.Login;
import br.com.academyflash.framework.dao.DaoFramework;

public class LoginDao {
	
	public void inserir(Login login)  {
		try {
			String sql = "insert into login (usuario, senha, nivel) values (?,?,?)";
			int id = DaoFramework.executeUpdateRetornaKeyGerada( sql, login.getUsuario(), 
                                login.getSenha(), login.getNivel());
			login.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void atualizar(Login login){
		try {
			String sql = "update login set usuario = ?, senha = ?, nivel = ? where id = ?";
			DaoFramework.executeUpdate(sql, login.getUsuario(), login.getSenha(), login.getNivel(), login.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir(Login login){
		try {
			String sql = "delete from login where id = ?";
			DaoFramework.executeUpdate(sql, login.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Login> listarTodos(){
		List<Login> list = new ArrayList<>();
		String sql = "select * from login";
		try (Connection conn = DaoFramework.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
			while(rs.next()){
				list.add(new Login(rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"), rs.getInt("nivel")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
