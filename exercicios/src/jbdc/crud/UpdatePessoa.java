package jbdc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import jbdc.Conexao;
import jbdc.crud.entity.Pessoa;

public class UpdatePessoa {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Escreva o nome da pessoa que você deseja alterar");
		String nomeFiltrado = scan.nextLine();
		List<Pessoa> pessoas = ReadPessoasComWhere.getPessoaByName(nomeFiltrado);
		if (Optional.ofNullable(pessoas).isPresent()) {
			for (Pessoa pessoa : pessoas) {
				System.out.println("Nome pessoa Filtrado: " + pessoa.getNome());
				System.out.println("Escreva o novo nome da pessoa");
				String nomeAlterar = scan.nextLine();
				alterarNomePessoaById(pessoa.getId(), nomeAlterar);
				System.out.println("Nome Alterado com Sucesso\n");
			}
		} else {
			System.out.println("Pessoa não Econtrada");
		}
		
		ReadPessoas.listarPessoas();
		scan.close();
		
	}
	
	public static void alterarNomePessoaById(int id, String nomeNovo) throws SQLException {
		Connection con = Conexao.getCon();
		
		String sql = "UPDATE pessoas SET nome = ? WHERE id = ?;";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nomeNovo);
		stmt.setInt(2, id);
		stmt.execute();
		
		con.close();
	}
}
