package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
//		String jpql = "SELECT u FROM Usuario u";
//
//		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
//		query.setMaxResults(5);
//		
//		List<Usuario> usuario = query.getResultList();
		
		List<Usuario> usuario = em
				.createQuery("SELECT u FROM Usuario u", Usuario.class)
				.setMaxResults(5)
				.getResultList();
							
		System.out.println("\n\n");
		usuario.stream().forEach(System.out::println);
		
		em.close();
		emf.close();

	}

}
