package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.modelDao.CargoDao;

// Container do Spring
@Repository
public class JpaCargoDao implements CargoDao {

	
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
		public List<Cargo> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT pro "//16
			        		+ "FROM Cargo pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_cargo");

			@SuppressWarnings("unchecked")
			List<Cargo> cargos = query.getResultList();

			return cargos;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Cargo> Read_History() {

	    	Query query = manager
	    	.createQuery("SELECT pro "
				        		+ "FROM Cargo pro "
				        		+ "ORDER BY pro.id_cargo ASC");

				@SuppressWarnings("unchecked")
				List<Cargo> cargos = query.getResultList();

			return cargos;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Cargo> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT pro.id_cargo, pro.car_nome "//16
				        		+ "FROM Cargo pro "
				        		+ "WHERE pro.deleted = false "
				        		+ "ORDER BY pro.id_cargo");

				@SuppressWarnings("unchecked")
				List<Cargo> cargos = query.getResultList();

				return cargos;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Cargo Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT cargo "//16
			        		+ "FROM Cargo cargo "
			        		+ "WHERE cargo.id_cargo = :Id");
	    	
			query.setParameter("Id", id);

			Cargo cargo = (Cargo) query.getSingleResult();
			
		   return cargo;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Cargo cargo) {
			cargo.setCreated_at(cal.getTime());
			cargo.setUpdated_at(cal.getTime());
			cargo.setDeleted(false);
			 manager.persist(cargo);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Cargo cargo) {
			cargo.setUpdated_at(cal.getTime());
			manager.merge(cargo);
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
				   .createQuery("UPDATE Cargo pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_cargo = :id");
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
				   .createQuery("UPDATE Cargo pro "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.id_cargo = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
