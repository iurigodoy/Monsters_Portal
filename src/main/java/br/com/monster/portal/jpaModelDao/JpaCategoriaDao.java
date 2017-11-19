package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;

@Repository
public class JpaCategoriaDao implements CategoriaDao {
	
	@PersistenceContext
	EntityManager manager;
	
		public List<Object> read() {
	    	Query query = manager
			        .createQuery("SELECT pro "//16
			        		+ "FROM Categoria pro ");

			@SuppressWarnings("unchecked")
			List<Object> categorias = query.getResultList();
			return categorias;
		}
	   
	   public Categoria findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT categoria "//16
			        		+ "FROM Categoria categoria "
			        		+ "WHERE categoria.id_categoria = :Id");
	    	
			query.setParameter("Id", id);

			Categoria categoria = (Categoria) query.getSingleResult();
			
		   return categoria;
	   }
	   
		public void create(Object object) {
			Categoria categoria = (Categoria) object;
			categoria.criarHistorico();
			 manager.persist(categoria);
	    }

		public void update(Object object) {
			Categoria categoria = (Categoria) object;
			categoria.atualizarHistorico();
			manager.merge(categoria);
		}
		
		public void delete(Long id) {
			Query query = manager
					   .createQuery("UPDATE Categoria pro "
					   				+ "SET pro.deleted = true, "
					   				+ "pro.deleted_at = :Deleted_at "
	  								+ "WHERE pro.id_categoria = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
		}

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Categoria pro "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.id_categoria = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
