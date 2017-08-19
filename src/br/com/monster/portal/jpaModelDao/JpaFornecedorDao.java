package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.modelDao.FornecedorDao;

@Repository
public class JpaFornecedorDao implements FornecedorDao {
	
	@PersistenceContext
	EntityManager manager;
	
		public List<Object> read() {
	    	Query query = manager
			        .createQuery("SELECT forn "//16
			        		+ "FROM Fornecedor forn "
			        		+ "ORDER BY forn.nome_for");

			@SuppressWarnings("unchecked")
			List<Object> fornecedores = query.getResultList();
			return fornecedores;
		}
	   
	public Fornecedor findOne(Long id){
		Query query = manager
			        .createQuery("SELECT fornecedor "//16
			        		+ "FROM Fornecedor fornecedor "
			        		+ "WHERE fornecedor.id_fornecedor = :Id");
	    
		query.setParameter("Id", id);
		Fornecedor fornecedor = (Fornecedor) query.getSingleResult();
		return fornecedor;
	}
	   
		public void create(Object object) {
			Fornecedor fornecedor = (Fornecedor) object;
			fornecedor.criarHistorico();
			 manager.persist(fornecedor);
	    }
		
		public void update(Object object) {
			Fornecedor fornecedor = (Fornecedor) object;
			fornecedor.atualizarHistorico();
			manager.merge(fornecedor);
		}

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Fornecedor forn "
				   				+ "SET forn.deleted = true, "
				   				+ "forn.deleted_at = :Deleted_at "
   								+ "WHERE forn.id_fornecedor = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Fornecedor fornecedor "
				   				+ "SET fornecedor.deleted = false "
   								+ "WHERE fornecedor.id_fornecedor = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
}
