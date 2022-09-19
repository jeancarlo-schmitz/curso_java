package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario =  em.find(Usuario.class, 2L);
		usuario.setNome("Jean Carlo");
		usuario.setEmail("jean-carlo@testemail.com");
		
//		Nesse caso como o objeto está em um estado gerenciado, mesmo sem o merge, ele vai gerar um update
//		Para corrigir isso, será feito no AlterarUsuario3
		//em.merge(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
