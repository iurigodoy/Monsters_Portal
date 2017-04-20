package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Relatorios;
import br.com.monster.portal.modelDao.RelatoriosDao;



// Container do Spring
@Repository
public class JpaRelatoriosDao implements RelatoriosDao {

	
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
		public List<Relatorios> Read() {
			
				/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Relatorios pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_relatorios ASC");

			@SuppressWarnings("unchecked")
			List<Relatorios> relatorios = query.getResultList();

			return relatorios;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Relatorios Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT relatorios "//16
			        		+ "FROM Relatorios relatorios "
			        		+ "WHERE relatorios.id_relatorios = :Id");
	    	
			query.setParameter("Id", id);

			Relatorios relatorios = (Relatorios) query.getSingleResult();
			
		   return relatorios;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Relatorios relatorios) {
			relatorios.setCreated_at(cal.getTime());
			 manager.persist(relatorios);
	    }
	   
}
