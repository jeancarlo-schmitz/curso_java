package jbdc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jbdc.Conexao;

public class DAO {
	private Connection con;
	
	public int incluir (String sql, Object...atributos) {
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			incluirAtributos(stmt, atributos);
			
			if(stmt.executeUpdate() > 0) {
				ResultSet resultado = stmt.executeQuery(sql);
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	private void incluirAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
		int indice = 1;
		for (Object atributo : atributos) {
			if(atributo instanceof String) {
				stmt.setString(indice, (String) atributo);
			}else if(atributo instanceof Integer) {
				stmt.setInt(indice, (Integer) atributo);
			}
			indice++;
		}
	}
	
	private Connection getCon() {
		try {
			if(con != null && !con.isClosed()) {
				return con;
			}
		} catch (SQLException e) {

		}
		con = Conexao.getCon();
		return con;
		
	}
}
