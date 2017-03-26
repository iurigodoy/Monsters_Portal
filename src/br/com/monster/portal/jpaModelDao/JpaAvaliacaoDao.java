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
	    *			Método Read				
	    * ----------------------------------
	    * 
	    * A seguir métodos de pesquisa
	    * 
	    */
		public List<Avaliacao> Read(Produto produto) {
			
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
		*	Método Read	History			
		*/
		public List<Avaliacao> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT ava "//16
			        		+ "FROM Avaliacao ava "
			        		+ "ORDER BY ava.id_avaliacao ASC");

			@SuppressWarnings("unchecked")
			List<Avaliacao> avaliacaos = query.getResultList();

			return avaliacaos;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Avaliacao> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT ava.id_avaliacao, pro.nome_produto "//16
				        		+ "FROM Avaliacao ava "
				        		+ "WHERE ava.produto = pro.id_produto "
				        		+ "ORDER BY ava.id_avaliacao ASC");

				@SuppressWarnings("unchecked")
				List<Avaliacao> avaliacaos = query.getResultList();

				return avaliacaos;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Avaliacao Find_One(Long id){
			
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
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
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
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Avaliacao avaliacao) {
			avaliacao.setUpdated_at(cal.getTime());
			manager.merge(avaliacao);
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
	    *			Método Restore			
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
