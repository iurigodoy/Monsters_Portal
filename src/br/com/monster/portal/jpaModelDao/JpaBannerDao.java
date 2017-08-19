package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.modelDao.BannerDao;

@Repository
public class JpaBannerDao implements BannerDao {
	
	@PersistenceContext
	EntityManager manager;

		public List<Object> read() {
			
	    	Query query = manager
			        .createQuery("SELECT ban "//16
			        		+ "FROM Banner ban INNER JOIN ban.produto pro "//33
			        		+ "WHERE ban.deleted = false "
			        		+ "ORDER BY ban.id_banner");

			@SuppressWarnings("unchecked")
			List<Object> banners = query.getResultList();
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
	   
	   public Banner findOne(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT banner "//16
			        		+ "FROM Banner banner "
			        		+ "WHERE banner.id_banner = :Id");
	    	
			query.setParameter("Id", id);

			Banner banner = (Banner) query.getSingleResult();
			
		   return banner;
	   }

		public void create(Object object) {
			Banner banner = (Banner) object;
			banner.criarHistorico();
			 manager.persist(banner);
	    }

		public void update(Object object) {
			Banner banner = (Banner) object;
			banner.atualizarHistorico();;
			manager.merge(banner);
		}

	   public void delete(Long id) {
		   Banner banner = findOne(id);
		   manager.remove(banner);
	   }

	public void restore(Long id) {
		// TODO
	}
	   
}
