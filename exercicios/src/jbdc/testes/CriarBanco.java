package jbdc.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306?verifyServerCertifcate=false&useSSL=true";
		String user = "root";
		String password = "j9775684";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java;");
		
		System.out.println("Banco criado com sucesso");
		con.close();
	}
}
