package jbdc.criarTabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jbdc.Conexao;

public class TabelaPessoas {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.getCon();
		
		Statement stmt = con.createStatement();
		
		String sql = "CREATE TABLE IF NOT EXISTS pessoas ("
				+ "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL"
				+ ")";
		
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso");
		con.close();
		
	}
}
