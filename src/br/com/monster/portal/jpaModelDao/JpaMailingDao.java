package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Mailing;
import br.com.monster.portal.modelDao.MailingDao;


// Container do Spring
@Repository
public class JpaMailingDao implements MailingDao {

	
	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    * A seguir métodos de pesquisa
	    * 
	    */
		public List<Mailing> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT mai "//16
			        		+ "FROM Mailing mai "
			        		+ "WHERE mai.deleted = false "
			        		+ "ORDER BY mai.id_mailing");

			@SuppressWarnings("unchecked")
			List<Mailing> mailings = query.getResultList();

			return mailings;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Mailing> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT mai "//16
			        		+ "FROM Mailing mai "
			        		+ "ORDER BY mai.id_mailing");

			@SuppressWarnings("unchecked")
			List<Mailing> mailings = query.getResultList();

			return mailings;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Mailing> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT mai.id_mailing, mai.mai_nome "//16
				        		+ "FROM Mailing mai "
				        		+ "WHERE mai.deleted = false "
				        		+ "ORDER BY mai.id_mailing");

				@SuppressWarnings("unchecked")
				List<Mailing> mailings = query.getResultList();

				return mailings;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Mailing Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT mailing "//16
			        		+ "FROM Mailing mailing "
			        		+ "WHERE mailing.id_mailing = :Id");
	    	
			query.setParameter("Id", id);

			Mailing mailing = (Mailing) query.getSingleResult();
			
		   return mailing;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Mailing mailing) {
			 manager.persist(mailing);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Mailing mailing) {
			manager.merge(mailing);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Long id) {
		   
		   Date datetime = cal.getTime();
		   
		   Query query = manager
				   .createQuery("UPDATE Mailing mai "
				   				+ "SET mai.deleted = true, "
				   				+ "mai.deleted_at = :Deleted_at "
   								+ "WHERE mai.id_mailing = :id");
			query.setParameter("Deleted_at", datetime);
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
	   /*
	    * ----------------------------------
	    *			Método Restore			
	    * ----------------------------------
	    * 
	    */

	   public void restore(Long id) {
		   
		   Query query = manager
				   .createQuery("UPDATE Mailing mailing "
				   				+ "SET mai.deleted = false "
   								+ "WHERE mai.id_mailing = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
