package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;

// Container do Spring
@Repository
public class JpaCategoriaDao implements CategoriaDao {

	
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
		public List<Categoria> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT pro "//16
			        		+ "FROM Categoria pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_categoria ASC");

			@SuppressWarnings("unchecked")
			List<Categoria> categorias = query.getResultList();

			return categorias;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Categoria findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT categoria "//16
			        		+ "FROM Categoria categoria "
			        		+ "WHERE categoria.id_categoria = :Id");
	    	
			query.setParameter("Id", id);

			Categoria categoria = (Categoria) query.getSingleResult();
			
		   return categoria;
	   }
	
	@Override
	public List<Categoria> Find_produto_cat(String nome_categoria, Categoria categoria) {

		Query query = manager
		        .createQuery("SELECT cat "
		        		+ "FROM Categoria cat "
		        		+ "WHERE cat.id_categoria IN "
		        		+ "(SELECT categoria FROM Produto pro) "
		        		+ "AND cat.nome_categoria LIKE :Nome ");

		query.setParameter("Nome", (String) "%"+nome_categoria+"%");

			@SuppressWarnings("unchecked")
			List<Categoria> categorias = query.getResultList();

		return categorias;
	}

	@Override
	public Object Find_publico(String nome_categoria, Categoria categoria) {
		
    	Query query = manager
		        .createQuery("SELECT pro "
		        		+ "FROM Categoria pro "
		        		+ "WHERE nome_categoria = :Nome "
		        		+ "ORDER BY pro.id_categoria ASC");
		
		query.setParameter("Nome", (String) nome_categoria);

			@SuppressWarnings("unchecked")
			List<Categoria> categorias = query.getResultList();

		return categorias;
	}
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Categoria categoria) {
			categoria.setCreated_at(cal.getTime());
			categoria.setUpdated_at(cal.getTime());
			categoria.setDeleted(false);
			 manager.persist(categoria);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Categoria categoria) {
			categoria.setUpdated_at(cal.getTime());
			manager.merge(categoria);
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Delete			
	    * ----------------------------------
	    * 
	    */
		
		@Override
		public void delete(Long id) {
			   
			Date datetime = cal.getTime();
			
			Query query = manager
					   .createQuery("UPDATE Categoria pro "
					   				+ "SET pro.deleted = true, "
					   				+ "pro.deleted_at = :Deleted_at "
	  								+ "WHERE pro.id_categoria = :id");
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
				   .createQuery("UPDATE Categoria pro "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.id_categoria = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
