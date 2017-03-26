package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	    *			Método Read				
	    * ----------------------------------
	    * 
	    * A seguir métodos de pesquisa
	    * 
	    */
		public List<Imagem> Read() {
			
			/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
			
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Imagem pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_imagem ASC");

			@SuppressWarnings("unchecked")
			List<Imagem> imagems = query.getResultList();

			return imagems;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Imagem> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT pro "
				        		+ "FROM Imagem pro "
				        		+ "ORDER BY pro.id_imagem ASC");

			@SuppressWarnings("unchecked")
			List<Imagem> imagems = query.getResultList();

			return imagems;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Imagem> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT pro.id_imagem, pro.pro_nome "//16
				        		+ "FROM Imagem pro "
				        		+ "WHERE pro.deleted = false "
				        		+ "ORDER BY pro.id_imagem");

				@SuppressWarnings("unchecked")
				List<Imagem> imagems = query.getResultList();

				return imagems;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Imagem Find_One(Long id){
			
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
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Imagem imagem) {
			 manager.persist(imagem);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Imagem imagem) {
			manager.merge(imagem);
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
				   .createQuery("UPDATE Imagem pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_imagem = :id");
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
				   .createQuery("UPDATE Imagem imagem "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.imagem = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
