package jbdc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import jbdc.Conexao;
import jbdc.crud.entity.Pessoa;

public class ReadPessoasComWhere {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Escreva o nome da pessoa que deseja pesquisa");
		String nomeFiltrado = scan.nextLine();
		List<Pessoa> pessoas = getPessoaByName(nomeFiltrado);
		scan.close();
		
		if(Optional.of(pessoas).isPresent()) {
			pessoas.stream().map(Pessoa::toString).forEach(System.out::println);
		}else {
			System.out.println("Não foi encontrado ninguem com esse nome");
		}
	}
	
	public static List<Pessoa> getPessoaByName(String nomeFiltrado) throws SQLException {
		Connection con = Conexao.getCon();
		String sql = "SELECT * FROM pessoas WHERE nome like ?;";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + nomeFiltrado + "%");
	
		ResultSet resultado = pstmt.executeQuery();
		List<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(id, nome));
		}
		
		pstmt.close();
		con.close();
		return pessoas;
	}
}
