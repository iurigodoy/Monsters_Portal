package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Acesso;
import br.com.monster.portal.modelDao.AcessoDao;

// Container do Spring
@Repository
public class JpaAcessoDao implements AcessoDao {

	
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
		public List<Acesso> Read() {
			
	    	/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Acessos pro "
				        		+ "ORDER BY pro.id_acessos ASC");

			@SuppressWarnings("unchecked")
			List<Acesso> acessos = query.getResultList();

			return acessos;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Acesso> Read_History() {
			
		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Acessos pro "
				        		+ "ORDER BY pro.id_acessos ASC");

			@SuppressWarnings("unchecked")
			List<Acesso> acessos = query.getResultList();

			return acessos;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Acesso> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT pro.id_acesso, pro.acesso_nome "//16
				        		+ "FROM Acesso pro "
				        		+ "WHERE pro.deleted = false "
				        		+ "ORDER BY pro.id_acesso ASC");

				@SuppressWarnings("unchecked")
				List<Acesso> acessos = query.getResultList();

				return acessos;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Acesso Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT pro "//16
			        		+ "FROM Acesso pro "
			        		+ "WHERE pro.id_acesso = :Id");
	    	
			query.setParameter("Id", id);

			Acesso acesso = (Acesso) query.getSingleResult();
			
		   return acesso;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Acesso acesso) {
			acesso.setCreated_at(cal.getTime());
			 manager.persist(acesso);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Acesso acesso) {
			manager.merge(acesso);
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
				   .createQuery("UPDATE Acesso acesso "
				   				+ "SET pro.deleted = true, "
				   				+ "acesso.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_acesso = :id");
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
				   .createQuery("UPDATE Acesso acesso "
				   				+ "SET acesso.deleted = false "
   								+ "WHERE pro.id_acesso = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
