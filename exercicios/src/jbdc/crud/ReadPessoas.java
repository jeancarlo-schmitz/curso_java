package jbdc.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jbdc.Conexao;
import jbdc.crud.entity.Pessoa;

public class ReadPessoas {
	public static void main(String[] args) throws SQLException {
		listarPessoas();
	}
	
	public static void listarPessoas() throws SQLException {
		Connection con = Conexao.getCon();
		
		String sql = "SELECT * FROM pessoas";
		
		Statement stmt = con.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(id, nome));
		}
		pessoas.stream().map(Pessoa::toString).forEach(System.out::println);
		con.close();
	}
}
