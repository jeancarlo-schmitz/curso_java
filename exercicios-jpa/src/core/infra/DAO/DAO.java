package core.infra.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		 em = emf.createEntityManager();
	}
	
	public DAO<E> begin(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> commit(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> rollback(){
		em.getTransaction().rollback();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		return this.begin().incluir(entidade).commit();
	}
	
	public List<E> findAll(){
		return findAll(10, 0);
	}
	
	public List<E> findAll(int limit, int offset){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe não foi Informada");
		}
		
		String jpql = "SELECT e FROM " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe)
					.setMaxResults(limit)
					.setFirstResult(offset);
		
		return query.getResultList();
	}
	
	public List<E> consultar(String nomeConsulta, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for (int i = 0; i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params){
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public E findById(long id){

		return em.find(classe, id);
	}
	
	public void close() {
		em.close();
	}
}
