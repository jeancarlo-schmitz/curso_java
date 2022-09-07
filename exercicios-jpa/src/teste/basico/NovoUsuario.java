package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario("Biruleibi", "Biruleibi@testemail.com");
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
