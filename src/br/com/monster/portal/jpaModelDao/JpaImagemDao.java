package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.modelDao.ImagemDao;

@Repository
public class JpaImagemDao implements ImagemDao {
	
	@PersistenceContext
	EntityManager manager;
	   
	   public Imagem findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT imagem "//16
			        		+ "FROM Imagem imagem "
			        		+ "WHERE imagem.id_imagem = :Id");
	    	
			query.setParameter("Id", id);

			Imagem imagem = (Imagem) query.getSingleResult();
			
		   return imagem;
	   }
	   
		public void create(Imagem imagem) {
			 manager.persist(imagem);
	    }
		
		public void update(Imagem imagem) {
			manager.merge(imagem);
		}

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Imagem pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_imagem = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
