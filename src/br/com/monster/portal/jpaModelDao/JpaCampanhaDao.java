package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Campanha;
import br.com.monster.portal.modelDao.CampanhaDao;

// Container do Spring
@Repository
public class JpaCampanhaDao implements CampanhaDao {

	
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
		public List<Campanha> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT cam "//16
			        		+ "FROM Campanha cam "
			        		+ "WHERE cam.deleted = false "
			        		+ "ORDER BY cam.id_campanha");

			@SuppressWarnings("unchecked")
			List<Campanha> campanhas = query.getResultList();

			return campanhas;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Campanha Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT campanha "//16
			        		+ "FROM Campanha campanha "
			        		+ "WHERE campanha.id_campanha = :Id");
	    	
			query.setParameter("Id", id);

			Campanha campanha = (Campanha) query.getSingleResult();
			
		   return campanha;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Campanha cam) {
			 manager.persist(cam);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Campanha cam) {
			manager.merge(cam);
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
				   .createQuery("UPDATE Campanha cam "
				   				+ "SET cam.deleted = true, "
				   				+ "cam.deleted_at = :Deleted_at "
   								+ "WHERE cam.id_campanha = :id");
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
				   .createQuery("UPDATE Campanha cam "
				   				+ "SET cam.deleted = false "
   								+ "WHERE cam.id_campanha = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
