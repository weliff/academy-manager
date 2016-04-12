package br.com.academyflash.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoFramework {
	
	private static final ThreadLocal<Connection> transacao = new ThreadLocal<>();
	
	
	public static Connection getConnection() throws SQLException{
			Connection conn = null;
			String url = "jdbc:postgresql://localhost/AcademyFlash";
			conn =  DriverManager.getConnection(url, "postgres", "wallifi");
			return conn;
	}
	
	public static void iniciarTransacaoComplexa() throws SQLException{
		if (isTransacaoIniciada())return;
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		transacao.set(conn);
	}
	
	public static Connection getConnectionDaTransacaoComplexa() throws SQLException{
		Connection conn =  transacao.get();
		if(conn == null){
			throw new SQLException("A transacao nao foi iniciada");
		}
		return conn;
	}
	
	private static boolean isTransacaoIniciada(){
		return transacao.get() != null;
	}

	public static void executeUpdate(Connection conn, String sql, Object...obj) throws SQLException{
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			int i = 1;
			for (Object object : obj) {
				stmt.setObject(i++, object);
			}
			stmt.executeUpdate();
		}
	}
	
	public static void executeUpdate(String sql, Object...obj) throws SQLException{
		Connection conn = getConnection();
		executeUpdate(conn, sql, obj);
		release(conn);
	}
	
	public static int executeUpdateRetornaKeyGerada(Connection conn, String sql, Object...obj) throws SQLException{
		int key = 0;
		try (PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
			int i = 1;
			for (Object object : obj) {
				stmt.setObject(i++, object);
			}
			stmt.executeUpdate();
			try(ResultSet rs = stmt.getGeneratedKeys()){
				if(rs.next()){
					key = rs.getInt(1);
				}
			}
		}
			return key;
	}
	
	public static int executeUpdateRetornaKeyGerada(String sql, Object...obj) throws SQLException{
		Connection conn = getConnection();
		int key = executeUpdateRetornaKeyGerada(conn, sql, obj);
		release(conn);
		return key;
	}
	
	public static void terminarTransacao() throws SQLException{
	
		try(Connection conn = transacao.get()){
			if(conn == null) return;
			commit(conn);
		}
		transacao.remove();
	}
	
	public static void commit (Connection conn) throws SQLException{
		conn.commit();
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollbackTransaoComplexa(){
		try (Connection conn = transacao.get()) {
			rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		transacao.remove();
	}
	
	public static void release(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void release(Connection conn, PreparedStatement stmt){
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void release(Connection conn, PreparedStatement stmt, ResultSet rs){
		try {
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
