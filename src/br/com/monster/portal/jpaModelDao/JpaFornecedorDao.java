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
	    *			M�todo Read				
	    * ----------------------------------
	    * 
	    * A seguir m�todos de pesquisa
	    * 
	    */
		public List<Fornecedor> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT forn "//16
			        		+ "FROM Fornecedor forn "
			        		+ "ORDER BY forn.nome_for");

			@SuppressWarnings("unchecked")
			List<Fornecedor> fornecedores = query.getResultList();

			return fornecedores;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Fornecedor findOne(Long id){
			
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
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
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
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Fornecedor fornecedor) {
			fornecedor.setUpdated_at(cal.getTime());
			manager.merge(fornecedor);
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
	    *			M�todo Restore			
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
