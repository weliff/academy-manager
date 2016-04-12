package br.com.academyflash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academyflash.entidades.Contato;
import br.com.academyflash.entidades.Endereco;
import br.com.academyflash.framework.dao.DaoFramework;

public class EnderecoDao {

	public void inserir(Endereco endereco) throws ExecuteUpdateException {
		try {
			String sql = "insert into endereco(endereco, numero, complemento, bairro, cidade, cep) values (?,?,?,?,?,?)";
			int id = DaoFramework.executeUpdateRetornaKeyGerada(
					DaoFramework.getConnectionDaTransacaoComplexa(), sql,
					endereco.getEndereco(), endereco.getNumero(),
					endereco.getComplemento(), endereco.getBairro(),
					endereco.getCidade(), endereco.getCep());
			endereco.setId(id);
		} catch (SQLException e) {
			throw new ExecuteUpdateException("Ocorreu um erro ao inserir o Endereco.", e);
		}
	}
	
	public void atualizar(Endereco endereco) throws ExecuteUpdateException {
		try {
			String sql = "update endereco set endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ? where id = ?";
			DaoFramework.executeUpdate(
					DaoFramework.getConnectionDaTransacaoComplexa(), sql,
					endereco.getEndereco(), endereco.getNumero(),
					endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(), endereco.getId());
		} catch (SQLException e) {
			throw new ExecuteUpdateException(
					"Ocorreu um erro ao atualizar o Endereco", e);
		}

	}
	
	public void excluir(Endereco endereco) throws ExecuteUpdateException{
		try {
			String sql = "delete from endereco where id = ?";
			DaoFramework.executeUpdate(DaoFramework.getConnectionDaTransacaoComplexa(), sql, endereco.getId());
		} catch (SQLException e) {
			throw new ExecuteUpdateException("Ocorreu um erro ao excluir o Endereco.", e);
		}
		
	}
	public List<Endereco> listarTodos(){
		List<Endereco> list = new ArrayList<>();
		String sql = "select * from endereco";
		try(Connection conn = DaoFramework.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
			while(rs.next()){
				list.add(new Endereco(rs.getInt("id"), rs.getString("endereco"), rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("cep")));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
