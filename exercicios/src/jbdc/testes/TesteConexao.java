package jbdc.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306?verifyServerCertifcate=false&useSSL=true";
		String user = "root";
		String password = "j9775684";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println("Conectado com sucesso");
		con.close();
	}

}
