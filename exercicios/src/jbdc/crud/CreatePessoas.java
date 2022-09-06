package jbdc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import jbdc.Conexao;

public class CreatePessoas {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o nome: ");
		String nome = scan.nextLine();
		
		Connection con = Conexao.getCon();
		String sql = "INSERT INTO pessoas (nome) VALUES (?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();
		System.out.println("Pessoas incluida com sucesso");
		
		scan.close();
	}
}
