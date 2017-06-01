package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.modelDao.BannerDao;

// Container do Spring
@Repository
public class JpaBannerDao implements BannerDao {

	
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
		public List<Banner> read() {
			
	    	Query query = manager
			        .createQuery("SELECT ban "//16
			        		+ "FROM Banner ban INNER JOIN ban.produto pro "//33
			        		+ "WHERE ban.deleted = false "
			        		+ "ORDER BY ban.id_banner");

			@SuppressWarnings("unchecked")
			List<Banner> banners = query.getResultList();

			return banners;
		}
		
		
		public List<Banner> Read_publico() {
			
	    	Query query = manager
			        .createQuery("SELECT ban "//16
			        		+ "FROM Banner ban INNER JOIN ban.produto pro "//33
			        		+ "WHERE ban.deleted = false "
			        		//+ "AND ban.ativo = true "
			        		+ "ORDER BY ban.id_banner");

			@SuppressWarnings("unchecked")
			List<Banner> banners = query.getResultList();

			return banners;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Banner findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT banner "//16
			        		+ "FROM Banner banner "
			        		+ "WHERE banner.id_banner = :Id");
	    	
			query.setParameter("Id", id);

			Banner banner = (Banner) query.getSingleResult();
			
		   return banner;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Banner banner) {
			banner.setCreated_at(cal.getTime());
			banner.setUpdated_at(cal.getTime());
			banner.setDeleted(false);
			 manager.persist(banner);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Banner banner) {
			banner.setUpdated_at(cal.getTime());
			manager.merge(banner);
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Long id) {
		   Banner banner = findOne(id);
		   manager.remove(banner);
	   }

	public void restore(Long id) {
	}
	   
}
