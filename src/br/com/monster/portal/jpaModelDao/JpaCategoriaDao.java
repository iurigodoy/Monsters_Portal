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
	    *			Método Read				
	    * ----------------------------------
	    * 
	    * A seguir métodos de pesquisa
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
		*	Método Read	History			
		*/
		public List<Categoria> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT pro "
				        		+ "FROM Categoria pro "
				        		+ "ORDER BY pro.id_categoria ASC");

				@SuppressWarnings("unchecked")
				List<Categoria> categorias = query.getResultList();

			return categorias;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Categoria> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT pro.id_categoria, pro.nome_categoria "//16
				        		+ "FROM Categoria pro "
				        		+ "WHERE pro.deleted = false "
				        		+ "ORDER BY pro.id_categoria");

				@SuppressWarnings("unchecked")
				List<Categoria> categorias = query.getResultList();

				return categorias;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Categoria Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT categoria "//16
			        		+ "FROM Categoria categoria "
			        		+ "WHERE categoria.id_categoria = :Id");
	    	
			query.setParameter("Id", id);

			Categoria categoria = (Categoria) query.getSingleResult();
			
		   return categoria;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
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
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Categoria categoria) {
			categoria.setUpdated_at(cal.getTime());
			manager.merge(categoria);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */
		public void delete(Categoria categoria) {
		   // Procura o ID
			Categoria categorias = manager.find(Categoria.class, categoria.getId_categoria());
			// Deleta
			manager.remove(categorias);
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
	    *			Método Restore			
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
