package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.basico.Usuario;

public class AlterarUsuario3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario =  em.find(Usuario.class, 2L);
//		Agora sim, com o detach ele só irá gerar um update, caso tenha o em.merge();
		em.detach(usuario);
		usuario.setNome("Jean Carlo");
		usuario.setEmail("jean-carlo@testemail.com");

		em.merge(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
