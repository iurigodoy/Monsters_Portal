package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Parcela;
import br.com.monster.portal.modelDao.ParcelaDao;


// Container do Spring
@Repository
public class JpaParcelaDao implements ParcelaDao {

	
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
		public List<Parcela> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT parc "//16
			        		+ "FROM Parcela parc "
			        		+ "WHERE parc.deleted = false "
			        		+ "ORDER BY parc.id_parcela");

			@SuppressWarnings("unchecked")
			List<Parcela> parcelas = query.getResultList();

			return parcelas;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Parcela> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT parc "//16
			        		+ "FROM Parcela parc "
			        		+ "ORDER BY parc.id_parcela");

			@SuppressWarnings("unchecked")
			List<Parcela> mensagens = query.getResultList();

			return mensagens;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Parcela> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT parc.id_parcela, parc.parc_numero "//16
				        		+ "FROM Parcela parc "
				        		+ "WHERE parc.deleted = false "
				        		+ "ORDER BY parc.id_parcela");

				@SuppressWarnings("unchecked")
				List<Parcela> parcelas = query.getResultList();

				return parcelas;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Parcela Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT parcela "//16
			        		+ "FROM Parcela parcela "
			        		+ "WHERE parcela.id_parcela = :Id");
	    	
			query.setParameter("Id", id);

			Parcela parcela = (Parcela) query.getSingleResult();
			
		   return parcela;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Parcela parcela) {
			parcela.setCreated_at(cal.getTime());
			parcela.setUpdated_at(cal.getTime());
			 manager.persist(parcela);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Parcela parcela) {
			parcela.setUpdated_at(cal.getTime());
			manager.merge(parcela);
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
				   .createQuery("UPDATE Parcela parc "
				   				+ "SET parc.deleted = true, "
				   				+ "parc.deleted_at = :Deleted_at "
   								+ "WHERE parc.id_parcela = :id");
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
				   .createQuery("UPDATE Parcela parcela "
				   				+ "SET parc.deleted = false "
   								+ "WHERE parc.id_parcela = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
