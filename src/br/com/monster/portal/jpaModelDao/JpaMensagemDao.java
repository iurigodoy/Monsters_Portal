package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Mensagem;
import br.com.monster.portal.modelDao.MensagemDao;


// Container do Spring
@Repository
public class JpaMensagemDao implements MensagemDao {

	
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
		public List<Mensagem> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT msg "//16
			        		+ "FROM Mensagem msg "
			        		+ "WHERE msg.deleted = false "
			        		+ "ORDER BY msg.id_mensagem");

			@SuppressWarnings("unchecked")
			List<Mensagem> mensagens = query.getResultList();

			return mensagens;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Mensagem> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT msg.id_mensagem, msg.msg_titulo "//16
				        		+ "FROM Mensagem msg "
				        		+ "WHERE msg.deleted = false "
				        		+ "ORDER BY msg.id_mensagem");

				@SuppressWarnings("unchecked")
				List<Mensagem> mensagens = query.getResultList();

				return mensagens;
			}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Mensagem Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT mensagem "//16
			        		+ "FROM Mensagem mensagem "
			        		+ "WHERE mensagem.id_mensagem = :Id");
	    	
			query.setParameter("Id", id);

			Mensagem mensagem = (Mensagem) query.getSingleResult();
			
		   return mensagem;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Mensagem mensagem) {
			 manager.persist(mensagem);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Mensagem mensagem) {
			manager.merge(mensagem);
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
				   .createQuery("UPDATE Mensagem msg "
				   				+ "SET msg.deleted = true, "
				   				+ "msg.deleted_at = :Deleted_at "
   								+ "WHERE msg.id_mensagem = :id");
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
				   .createQuery("UPDATE Mensagem mensagem "
				   				+ "SET msg.deleted = false "
   								+ "WHERE msg.id_mensagem = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
