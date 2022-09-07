package jbdc.DAO;

import java.sql.SQLException;
import java.util.List;

import jbdc.crud.entity.Pessoa;

public class DAOTeste {

	public static void main(String[] args) throws SQLException {
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES(?)";
		
		dao.incluir(sql, "Xesque Dele");
		dao.incluir(sql, "Zezinho");
		dao.incluir(sql, "Dorisvaldo Cruz");
		dao.incluir(sql, "ZÈZÈ di Camargo");
		
		List<Pessoa> pessoas = dao.listarPessoas();
		pessoas.stream().map(Pessoa::toString).forEach(System.out::println);
		
		dao.close();
	}
}
