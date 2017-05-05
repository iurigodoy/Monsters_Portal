package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import JpaUtil.JpaResultHelper;
import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.modelDao.FuncionarioDao;
import br.com.monster.portal.security.Crypt;


// Container do Spring
@Repository
public class JpaFuncionarioDao implements FuncionarioDao {

	
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
		public List<Funcionario> read() {
			
	    	Query query = manager
			        .createQuery("SELECT fun "//16
			        		+ "FROM Funcionario fun");

			@SuppressWarnings("unchecked")
			List<Funcionario> funcionarios = query.getResultList();

			return funcionarios;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
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
				
				Funcionario funcionario = (Funcionario) JpaResultHelper.getSingleResultOrNull(query);		// armazena no Objeto
				
				return funcionario;
		}
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Funcionario funcionario) {
			funcionario.setCreated_at(cal.getTime());
			funcionario.setUpdated_at(cal.getTime());
			funcionario.setDeleted(false);
			 manager.persist(funcionario);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Funcionario funcionario) {
			funcionario.setUpdated_at(cal.getTime());
			manager.merge(funcionario);
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Long id) {
		   
		   Date datetime = cal.getTime();
		   
		   Query query = manager
				   .createQuery("UPDATE Funcionario fun "
				   				+ "SET fun.deleted = true, "
				   				+ "fun.deleted_at = :Deleted_at "
   								+ "WHERE fun.id_funcionario = :id");
			query.setParameter("Deleted_at", datetime);
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
	   /*
	    * ----------------------------------
	    *			M�todo Restore			
	    * ----------------------------------
	    * 
	    */

	   public void restore(Long id) {
		   
		   Query query = manager
				   .createQuery("UPDATE Funcionario funcionario "
				   				+ "SET fun.deleted = false "
   								+ "WHERE fun.funcionario = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
