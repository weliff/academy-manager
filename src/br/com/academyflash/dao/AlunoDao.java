package br.com.academyflash.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academyflash.entidades.Aluno;
import br.com.academyflash.entidades.Contato;
import br.com.academyflash.entidades.Endereco;
import br.com.academyflash.framework.dao.DaoFramework;

public class AlunoDao {
	private ContatoDao contatoDao;
	private EnderecoDao enderecoDao; 
	
        public AlunoDao(){
            contatoDao = new ContatoDao();
            enderecoDao = new EnderecoDao();
        }
        
        public void inserir(Aluno aluno) {

		try {
			DaoFramework.iniciarTransacaoComplexa();
			contatoDao.inserir(aluno.getContato());
			enderecoDao.inserir(aluno.getEndereco());
			String sql = "insert into aluno (id_instrutor, id_contato, id_endereco, nome,  cpf, rg, genero, nome_instrutor, turno, data_inscricao) values (?,?,?,?,?,?,?,?,?,?)";
			int id = DaoFramework.executeUpdateRetornaKeyGerada(DaoFramework
					.getConnectionDaTransacaoComplexa(), sql, aluno
					.getFuncionario().getId(), aluno.getContato().getId(),
					aluno.getEndereco().getId(), aluno.getNome(), aluno
							.getCpf(), aluno.getRg(), aluno.getGenero(), aluno
							.getNomeDoInstrutor(), aluno.getTurno(), new Date(
							aluno.getDataDeInscricao().getTime()));
			aluno.setId(id);
			DaoFramework.terminarTransacao();
		} catch (SQLException | ExecuteUpdateException e) {
			DaoFramework.rollbackTransaoComplexa();
			e.printStackTrace();
		}

	}

	public void atualizar(Aluno aluno) {
		try {
			DaoFramework.iniciarTransacaoComplexa();
			contatoDao.atualizar(aluno.getContato());
			enderecoDao.atualizar(aluno.getEndereco());
			String sql = "update aluno set id_instrutor = ?, id_contato = ?, id_endereco = ?, nome = ?,  cpf = ?, rg = ?, genero = ?, "
					+ "nome_instrutor = ?, turno = ?, data_inscricao = ? where id = ?";
			DaoFramework.executeUpdate(DaoFramework
					.getConnectionDaTransacaoComplexa(), sql, aluno
					.getFuncionario().getId(), aluno.getContato().getId(),
					aluno.getEndereco().getId(), aluno.getNome(), aluno
							.getCpf(), aluno.getRg(), aluno.getGenero(), aluno
							.getNomeDoInstrutor(), aluno.getTurno(), new Date(
							aluno.getDataDeInscricao().getTime()), aluno.getId());

		} catch (SQLException | ExecuteUpdateException e) {
			DaoFramework.rollbackTransaoComplexa();
			e.printStackTrace();
			System.err.println("Ocorreu um erro ao tentar atualizar o aluno");
		}

	}

	public void excluir(Aluno aluno) {
		try {
			DaoFramework.iniciarTransacaoComplexa();
			contatoDao.excluir(aluno.getContato());
			enderecoDao.excluir(aluno.getEndereco());
			String sql = "detele from aluno where id = ?";
			DaoFramework.executeUpdate(
					DaoFramework.getConnectionDaTransacaoComplexa(), sql,
					aluno.getId());
		} catch (SQLException | ExecuteUpdateException e) {
			DaoFramework.rollbackTransaoComplexa();
			e.printStackTrace();
			System.err.println("Ocorreu um erro ao tentar excluir o aluno");
		}
	}

	public List<Aluno> listarTodos() {
		List<Aluno> list = new ArrayList<>();
		String sql = "select * from aluno, endereco, contato where aluno.id_endereco = endereco.id and aluno.id_contato = contato.id";
		try (Connection conn = DaoFramework.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Contato contato = new Contato(rs.getInt("id_contato"),
						rs.getString("email"), rs.getString("telefone"),
						rs.getString("celular"));
				Endereco endereco = new Endereco(rs.getInt("id_endereco"),
						rs.getString("endereco"), rs.getInt("numero"),
						rs.getString("complemento"), rs.getString("bairro"),
						rs.getString("cidade"), rs.getString("cep"));
				list.add(new Aluno(rs.getInt("id"), rs.getString("nome"), rs
						.getString("cpf"), rs.getInt("rg"), rs
						.getString("genero"), contato, endereco, rs
						.getString("nome_instrutor"), rs.getString("turno"), rs
						.getDate("data_inscricao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
