package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.modelDao.FuncionarioDao;
import br.com.monster.portal.security.Crypt;

@Repository
public class JpaFuncionarioDao implements FuncionarioDao {
	
	@PersistenceContext
	EntityManager manager;

		public List<Object> read() {
	    	Query query = manager
			        .createQuery("SELECT fun "
			        		+ "FROM Funcionario fun");

			@SuppressWarnings("unchecked")
			List<Object> funcionarios = query.getResultList();
			return funcionarios;
		}
	   
	   public Funcionario findOne(Long id){
	    	Query query = manager
			        .createQuery("SELECT funcionario "//16
			        		+ "FROM Funcionario funcionario "
			        		+ "WHERE funcionario.id_funcionario = :Id");
	    	
			query.setParameter("Id", id);
			Funcionario funcionario = (Funcionario) query.getSingleResult();
			return funcionario;
	   }
	   

		public Funcionario autenticaEmailSenha(String email, String senha) {
			
			Crypt crypt = new Crypt();
			if(senha != null){
				senha = crypt.criptografar(senha);
			} else {
				return null;
			}

			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT fun FROM Funcionario as fun "
						
							+ "WHERE fun.email_fun = :email "
							+ "AND fun.senha_fun = :senha "
						
							+ "AND fun.id_funcionario IN "
							+ "(SELECT fun FROM Cargo cargo "
							
							+ "WHERE cargo.id_cargo IN "
							+ "(SELECT cargo FROM Permissao perm)) ");
			
						query.setParameter("email", email);
						query.setParameter("senha", senha);
				
				Funcionario funcionario = (Funcionario) query.getSingleResult();
				return funcionario;
		}
	   
		public void create(Object object) {
			Funcionario funcionario = (Funcionario) object;
			funcionario.criarHistorico();
			 manager.persist(funcionario);
	    }

		public void update(Object object) {
			Funcionario funcionario = (Funcionario) object;
			funcionario.atualizarHistorico();
			manager.merge(funcionario);
		}

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Funcionario fun "
				   				+ "SET fun.deleted = true, "
				   				+ "fun.deleted_at = :Deleted_at "
   								+ "WHERE fun.id_funcionario = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Funcionario fun "
				   				+ "SET fun.deleted = false "
   								+ "WHERE fun.id_funcionario = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
