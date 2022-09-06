package jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import jbdc.crud.ReadPessoas;
import jbdc.crud.ReadPessoasComWhere;
import jbdc.crud.entity.Pessoa;

public class DeletePessoa {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escreva o nome da(s) pessoa(s) que você deseja DELETAR");
		String nomeFiltrado = scan.nextLine();
		List<Pessoa> pessoas = ReadPessoasComWhere.getPessoaByName(nomeFiltrado);
		if (Optional.ofNullable(pessoas).isPresent()) {
			for (Pessoa pessoa : pessoas) {
				System.out.println("Nome pessoa Filtrado: " + pessoa.getNome());
				System.out.println("Deseja Excluir esse Registro?(S/n)");
				String valor = scan.nextLine();
				if(valor.equalsIgnoreCase("S")) {
					deletePessoaById(pessoa.getId());
					System.out.println("Nome EXCLUIDO com Sucesso\n");
				}else {
					System.out.println("Registro NÃO Excluido!");
				}
			}
		} else {
			System.out.println("Pessoa não Econtrada");
		}
		ReadPessoas.listarPessoas();
		scan.close();
	}
	
	public static void deletePessoaById(int id) throws SQLException {
		Connection con = Conexao.getCon();
		
		String sql = "DELETE FROM pessoas WHERE id = ?;";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		
		con.close();
	}
}
