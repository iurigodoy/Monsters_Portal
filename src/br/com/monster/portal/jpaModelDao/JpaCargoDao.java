package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.model.Permissao;
import br.com.monster.portal.modelDao.CargoDao;

@Repository
public class JpaCargoDao implements CargoDao {
	
	@PersistenceContext
	EntityManager manager;

		public List<Object> read() {
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Cargo pro "
			        		+ "ORDER BY pro.id_cargo");

			@SuppressWarnings("unchecked")
			List<Object> cargos = query.getResultList();
			return cargos;
		}
	   
	   public Cargo findOne(Long id){
	    	Query query = manager
			        .createQuery("SELECT cargo "
			        		+ "FROM Cargo cargo "
			        		+ "WHERE cargo.id_cargo = :Id");
			query.setParameter("Id", id);

			Cargo cargo = (Cargo) query.getSingleResult();
			return cargo;
	   }
	   
	   public Permissao findOnePermissao(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT permissao "
			        		+ "FROM Permissao permissao "
			        		+ "WHERE permissao.cargo.id_cargo = :Id");
	    	
			query.setParameter("Id", id);

			Permissao permissao = (Permissao) query.getSingleResult();
			
		   return permissao;
	   }
	   
		public void create(Cargo cargo, Permissao permissao) {
			cargo.criarHistorico();
			manager.persist(cargo);
			permissao.setCargo(cargo);
			manager.persist(permissao);
	    }

		public void update(Object object) {
			Cargo cargo = (Cargo) object;
			cargo.atualizarHistorico();;
			manager.merge(cargo);
		}
		
		public void updatePermissao(Permissao permissao) {
			manager.persist(permissao);
		}

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Cargo pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_cargo = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Cargo pro "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.id_cargo = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	public void create(Object object) {
		// TODO Auto-generated method stub
	}
}
