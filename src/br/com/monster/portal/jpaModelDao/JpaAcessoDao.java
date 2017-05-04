package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
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
	    *			M�todo Read				
	    * ----------------------------------
	    * 
	    * A seguir m�todos de pesquisa
	    * 
	    */
		public List<Acesso> Read() {

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
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Acesso acesso) {
			acesso.setCreated_at(cal.getTime());
			 manager.persist(acesso);
	    }
	   
}
