package br.com.academyflash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academyflash.entidades.Contato;
import br.com.academyflash.entidades.Funcionario;
import br.com.academyflash.framework.dao.DaoFramework;

public class ContatoDao {

	public void inserir(Contato contato) throws ExecuteUpdateException {
		try {
			String sql = "insert into contato(email, telefone, celular) values (?,?,?)";
			int id = DaoFramework.executeUpdateRetornaKeyGerada(
					DaoFramework.getConnectionDaTransacaoComplexa(), sql,
					contato.getEmail(), contato.getTelefone(),
					contato.getCelular());
			contato.setId(id);
		} catch (SQLException e) {
			throw new ExecuteUpdateException(
					"Ocorreu um erro ao inserir o Contato.", e);
		}
	}

	public void atualizar(Contato contato) throws ExecuteUpdateException {
		try {
			String sql = "update contato set email = ?, telefone = ?, celular = ? where id = ?";
			DaoFramework.executeUpdate(
					DaoFramework.getConnectionDaTransacaoComplexa(), sql,
					contato.getEmail(), contato.getTelefone(),
					contato.getCelular(), contato.getId());
		} catch (SQLException e) {
			throw new ExecuteUpdateException(
					"Ocorreu um erro ao atualizar o Contato", e);
		}

	}
	
	public void excluir(Contato contato) throws ExecuteUpdateException{
		try {
			String sql = "delete from contato where id = ?";
			DaoFramework.executeUpdate(DaoFramework.getConnectionDaTransacaoComplexa(), sql, contato.getId());
		} catch (SQLException e) {
			throw new ExecuteUpdateException("Ocorreu um erro ao excluir o Contato.", e);
		}
		
	}
	
	public List<Contato> listarTodos(){
		List<Contato> list = new ArrayList<>();
		String sql = "select * from contato";
		try(Connection conn = DaoFramework.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
			while(rs.next()){
				list.add(new Contato(rs.getInt("id"), rs.getString("email"), rs.getString("telefone"), rs.getString("celular")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
