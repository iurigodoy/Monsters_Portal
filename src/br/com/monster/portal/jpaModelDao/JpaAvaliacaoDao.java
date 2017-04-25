package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Avaliacao;
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

	   public void delete(long id) {
		   
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
	   
}
