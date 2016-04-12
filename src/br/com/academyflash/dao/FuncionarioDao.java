package br.com.academyflash.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academyflash.entidades.Contato;
import br.com.academyflash.entidades.Endereco;
import br.com.academyflash.entidades.Funcionario;
import br.com.academyflash.framework.dao.DaoFramework;

public class FuncionarioDao {

	private ContatoDao contatoDao = new ContatoDao();
	private EnderecoDao enderecoDao = new EnderecoDao();
	
	public void inserir(Funcionario funcionario)
			throws ExecuteUpdateException {

		try {
			contatoDao.inserir(funcionario.getContato());
			enderecoDao.inserir(funcionario.getEndereco());

			String sql = "insert into funcionario (id_contato, id_endereco, nome, cpf, rg, genero, funcao, data_contrato)"
					+ "values (?,?,?,?,?,?,?,?)";

			int id = DaoFramework.executeUpdateRetornaKeyGerada(DaoFramework
					.getConnectionDaTransacaoComplexa(), sql, funcionario
					.getContato().getId(), funcionario.getEndereco().getId(),
					funcionario.getNome(), funcionario.getCpf(), funcionario
							.getRg(), funcionario.getGenero(), funcionario
							.getFuncao(), new Date(funcionario
							.getData_contrato().getTime()));
			funcionario.setId(id);
		} catch (SQLException e) {
			throw new ExecuteUpdateException(
					"Ocorreu um erro ao tentar inserir o Funcionario.", e);
		}

	}
	
	public void inserirFuncionario(Funcionario funcionario){
		try {
			DaoFramework.iniciarTransacaoComplexa();
			inserir(funcionario);
			DaoFramework.terminarTransacao();
		} catch (SQLException | ExecuteUpdateException e) {
			DaoFramework.rollbackTransaoComplexa();
			e.printStackTrace();
		} 
	}

	public void atualizar(Funcionario funcionario){
		try {
			DaoFramework.iniciarTransacaoComplexa();
			
			String sql = "update funcionario set nome = ?, cpf = ?, rg = ?, genero = ?, funcao = ?, data_contrato = ? where id = ?";
			contatoDao.atualizar(funcionario.getContato());
			enderecoDao.atualizar(funcionario.getEndereco());
			DaoFramework.executeUpdate(DaoFramework.getConnectionDaTransacaoComplexa(), sql, funcionario.getNome(), funcionario.getCpf(), 
					funcionario.getRg(), funcionario.getGenero(),
					funcionario.getFuncao(), new Date(funcionario.getData_contrato().getTime()), funcionario.getId());
			
			DaoFramework.terminarTransacao();
		} catch (SQLException | ExecuteUpdateException e) {
			DaoFramework.rollbackTransaoComplexa();
			System.err.println("Ocorreu um erro ao tentar atualizar o funcionario ");
			e.printStackTrace();
		}
	}
	
	public void excluir(Funcionario funcionario) throws ExecuteUpdateException{
		try {
			DaoFramework.iniciarTransacaoComplexa();
			contatoDao.excluir(funcionario.getContato());
			contatoDao.excluir(funcionario.getContato());
			String sql = "delete from funcionario where id = ?";
			DaoFramework.executeUpdate(DaoFramework.getConnectionDaTransacaoComplexa(), sql, funcionario.getId());
			
			DaoFramework.terminarTransacao();
		} catch (SQLException e) {
			DaoFramework.rollbackTransaoComplexa();
			e.printStackTrace();
			System.err.println("Ocorreu um erro ao tentar excluir o funcionario");
		}
	}
	
	public List<Funcionario> listarTodos(){
		List<Funcionario> list = new ArrayList<>();
		String sql = "select * from funcionario, endereco, contato where funcionario.id_endereco = endereco.id and funcionario.id_contato = contato.id";
		try(Connection conn = DaoFramework.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
			while(rs.next()){
				Contato contato = new Contato(rs.getInt(17), rs.getString("email"),rs.getString("telefone") , rs.getString("celular"));
				Endereco endereco = new Endereco(rs.getInt(10), rs.getString("endereco"), rs.getInt("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("cep"));				
				list.add(new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getLong("rg"), rs.getString("genero"), contato, endereco, rs.getString("funcao"), rs.getDate("data_contrato")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
