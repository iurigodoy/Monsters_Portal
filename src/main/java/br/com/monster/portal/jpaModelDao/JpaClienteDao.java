package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.ClienteDao;
import br.com.monster.portal.security.Crypt;

@Repository
public class JpaClienteDao implements ClienteDao {
	
	@PersistenceContext
	EntityManager manager;

		public List<Object> read() {
			
	    	Query query = manager
			        .createQuery("SELECT cli "
			        		+ "FROM Cliente cli ");

			@SuppressWarnings("unchecked")
			List<Object> clientes = query.getResultList();
			return clientes;
		}
			   
	public Cliente findOne(Long id) {
		Query query = manager
				.createQuery("SELECT cli FROM Cliente cli "
							+ "WHERE cli.id_cliente = :Id ");
		query.setParameter("Id", (long) id);

		Cliente clientes = (Cliente) query.getSingleResult();
		return clientes;
	}
		
		public Cliente autenticaEmailSenha(String email, String senha) {
			
			Crypt crypt = new Crypt();
			if(senha != null){
				senha = crypt.criptografar(senha);
			} else {
				return null;
			}
			
			Query query = manager
				.createQuery("SELECT cli FROM Cliente as cli "
							+ "WHERE cli.email_cli = :email "
							+ "AND cli.senha_cli = :senha");
		
							query.setParameter("email", email);
							query.setParameter("senha", senha);
			Cliente cliente = (Cliente) query.getSingleResult();
			return cliente;
			
		}
		
		public void create(Object object) {
			Cliente cliente = (Cliente) object;
			Crypt crypt = new Crypt();
			
			cliente.setSenha_cli(crypt.criptografar(cliente.getSenha_cli()));
			cliente.criarHistorico();
			 manager.persist(cliente);
	    }
		
		public void update(Object object) {
			Cliente cliente = (Cliente) object;
			cliente.atualizarHistorico();
			manager.merge(cliente);
		}

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Cliente cli "
				   				+ "SET cli.deleted = true, "
				   				+ "cli.deleted_at = :Deleted_at "
   								+ "WHERE cli.id_cliente = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Cliente cli "
				   				+ "SET cli.deleted = false "
   								+ "WHERE cli.id_cliente = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
