package br.com.academyflash.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academyflash.entidades.Aluno;
import br.com.academyflash.entidades.Medidas;
import br.com.academyflash.framework.dao.DaoFramework;

public class MedidasDao {

	public void inserir(Medidas medidas) {
		try {
			String sql = "insert into medidas(id_aluno, data_medida, braco_esquerdo, braco_direito, busto, cintura, circulo_abdominal, quadril, coxa_esquerda, coxa_direita, panturilha_esquerda,panturilha_direita values (?,?,?,?,?,?,?,?,?,?,?,?) ";
			int id = DaoFramework.executeUpdateRetornaKeyGerada(sql, medidas
					.getAluno().getId(), new Date(medidas.getDataMedida()
					.getTime()), medidas.getBracoEsquerdo(), medidas
					.getBracoDireito(), medidas.getBusto(), medidas
					.getCintura(), medidas.getCirculoAbdominal(), medidas
					.getQuadril(), medidas.getCoxaEsquerda(), medidas
					.getCoxaDireita(), medidas.getPanturilhaEsquerda(), medidas
					.getPanturilhaDireita());
			medidas.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Medidas medidas) {
		try {
			String sql = "delete from medidas where id = ?";
			DaoFramework.executeUpdate(sql, medidas.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Medidas> listarTodos(Aluno aluno) {
		List<Medidas> list = new ArrayList<>();
		String sql = "select * from medidas where id_aluno = ?";
		try (Connection conn = DaoFramework.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			
			stmt.setInt(1, aluno.getId());
			
			list.add(new Medidas(rs.getInt("id"), rs.getDate("data_medida"),
					aluno, rs.getDouble("braco_esquerdo"), rs.getDouble("braco_direito"), rs.getDouble("busto"),
					rs.getDouble("cintura"), rs.getDouble("circulo_abdominal"), rs.getDouble("quadril"), 
					rs.getDouble("coxa_esquerda"), rs.getDouble("coxa_direita"), rs.getDouble("panturilha_esquerda"), 
					rs.getDouble("panturilhaDireita")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
