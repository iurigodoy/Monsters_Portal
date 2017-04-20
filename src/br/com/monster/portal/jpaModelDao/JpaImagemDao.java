package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.modelDao.ImagemDao;


// Container do Spring
@Repository
public class JpaImagemDao implements ImagemDao {

	
	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Imagem findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT imagem "//16
			        		+ "FROM Imagem imagem "
			        		+ "WHERE imagem.id_imagem = :Id");
	    	
			query.setParameter("Id", id);

			Imagem imagem = (Imagem) query.getSingleResult();
			
		   return imagem;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Imagem imagem) {
			 manager.persist(imagem);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Imagem imagem) {
			manager.merge(imagem);
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
				   .createQuery("UPDATE Imagem pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_imagem = :id");
			query.setParameter("Deleted_at", datetime);
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
