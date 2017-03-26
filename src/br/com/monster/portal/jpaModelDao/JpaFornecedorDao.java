package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.modelDao.FornecedorDao;


// Container do Spring
@Repository
public class JpaFornecedorDao implements FornecedorDao {

	
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
		public List<Fornecedor> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT forn "//16
			        		+ "FROM Fornecedor forn "
			        		+ "WHERE forn.deleted = false "
			        		+ "ORDER BY forn.id_fornecedor");

			@SuppressWarnings("unchecked")
			List<Fornecedor> fornecedores = query.getResultList();

			return fornecedores;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Fornecedor> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT forn "//16
			        		+ "FROM Fornecedor forn "
			        		+ "ORDER BY forn.id_fornecedor");

			@SuppressWarnings("unchecked")
			List<Fornecedor> fornecedores = query.getResultList();

			return fornecedores;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Fornecedor> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT forn.id_fornecedor, forn.for_nome "//16
				        		+ "FROM Fornecedor forn "
				        		+ "WHERE forn.deleted = false "
				        		+ "ORDER BY forn.id_fornecedor");

				@SuppressWarnings("unchecked")
				List<Fornecedor> fornecedores = query.getResultList();

				return fornecedores;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Fornecedor Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT fornecedor "//16
			        		+ "FROM Fornecedor fornecedor "
			        		+ "WHERE fornecedor.id_fornecedor = :Id");
	    	
			query.setParameter("Id", id);

			Fornecedor fornecedor = (Fornecedor) query.getSingleResult();
			
		   return fornecedor;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Fornecedor fornecedor) {
			fornecedor.setCreated_at(cal.getTime());
			fornecedor.setUpdated_at(cal.getTime());
			fornecedor.setDeleted(false);
			 manager.persist(fornecedor);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Fornecedor fornecedor) {
			fornecedor.setUpdated_at(cal.getTime());
			manager.merge(fornecedor);
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
				   .createQuery("UPDATE Fornecedor forn "
				   				+ "SET forn.deleted = true, "
				   				+ "forn.deleted_at = :Deleted_at "
   								+ "WHERE forn.id_fornecedor = :id");
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
				   .createQuery("UPDATE Fornecedor fornecedor "
				   				+ "SET forn.deleted = false "
   								+ "WHERE forn.id_fornecedor = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
