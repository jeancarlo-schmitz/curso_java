package jbdc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jbdc.Conexao;
import jbdc.crud.entity.Pessoa;

public class DAO {
	private Connection con;
	
	public int incluir (String sql, Object...atributos) {
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			incluirAtributos(stmt, atributos);
			
			if(stmt.executeUpdate() > 0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public List<Pessoa> listarPessoas() {
		String sql = "SELECT * FROM pessoas";
		try {
			Statement stmt = getCon().createStatement();
			ResultSet resultado = stmt.executeQuery(sql);

			List<Pessoa> pessoas = new ArrayList<>();
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				pessoas.add(new Pessoa(id, nome));
			}
			return pessoas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void close() {
		try {
			getCon().close();
		} catch (SQLException e) {
			
		} finally {
			con = null;
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
