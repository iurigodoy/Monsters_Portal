package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.AvaliacaoDao;

// Container do Spring
@Repository
public class JpaAvaliacaoDao implements AvaliacaoDao {

	
	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
	   
	   /*
	    * ----------------------------------
	    *			M�todo Read				
	    * ----------------------------------
	    * 
	    * A seguir m�todos de pesquisa
	    * 
	    */
		public List<Avaliacao> read(Produto produto) {
			
			long id = produto.getId_produto();
			
	    	Query query = manager
			        .createQuery("SELECT ava "
				        	+ "FROM Avaliacao ava INNER JOIN ava.produto pro "
			        		+ "WHERE ava.deleted = false "
			                + "AND pro.id_produto = :Id "
							+ "ORDER BY ava.id_avaliacao ASC");
							
			query.setParameter("Id", id);

			@SuppressWarnings("unchecked")
			List<Avaliacao> avaliacaos = query.getResultList();

			return avaliacaos;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Avaliacao findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT ava "//16
			        		+ "FROM Avaliacao ava "
			        		+ "WHERE ava.id_avaliacao = :Id");
	    	
			query.setParameter("Id", id);

			Avaliacao avaliacaos = (Avaliacao) query.getSingleResult();
			
		   return avaliacaos;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Avaliacao avaliacao) {
			avaliacao.setCreated_at(cal.getTime());
			avaliacao.setUpdated_at(cal.getTime());
			avaliacao.setDeleted(false);
			 manager.persist(avaliacao);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Avaliacao avaliacao) {
			avaliacao.setUpdated_at(cal.getTime());
			manager.merge(avaliacao);
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Long id) {
		   
		   Date datetime = cal.getTime();
		   
		   Query query = manager
				   .createQuery("UPDATE Avaliacao ava "
				   				+ "SET ava.deleted = true, "
				   				+ "ava.deleted_at = :Deleted_at "
   								+ "WHERE ava.id_avaliacao = :id");
			query.setParameter("Deleted_at", datetime);
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
	   /*
	    * ----------------------------------
	    *			M�todo Restore			
	    * ----------------------------------
	    * 
	    */

	   public void restore(Long id) {
		   
		   Query query = manager
				   .createQuery("UPDATE Avaliacao ava "
				   				+ "SET ava.deleted = false "
   								+ "WHERE ava.id_avaliacao = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
