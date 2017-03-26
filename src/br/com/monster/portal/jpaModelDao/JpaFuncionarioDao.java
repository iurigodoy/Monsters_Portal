package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.modelDao.FuncionarioDao;


// Container do Spring
@Repository
public class JpaFuncionarioDao implements FuncionarioDao {

	
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
		public List<Funcionario> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT fun "//16
			        		+ "FROM Funcionario fun INNER JOIN fun.cargo car "//33
			        		+ "WHERE fun.deleted = false "
			        		+ "ORDER BY fun.id_funcionario ASC");

			@SuppressWarnings("unchecked")
			List<Funcionario> funcionarios = query.getResultList();

			return funcionarios;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Funcionario> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT fun "//16
			        		+ "FROM Funcionario fun "
			        		+ "ORDER BY fun.id_funcionario");

			@SuppressWarnings("unchecked")
			List<Funcionario> funcionarios = query.getResultList();

			return funcionarios;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Funcionario> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT fun.id_funcionario, fun.fun_nome "//16
				        		+ "FROM Funcionario fun "
				        		+ "WHERE fun.deleted = false "
				        		+ "ORDER BY fun.id_funcionario");

				@SuppressWarnings("unchecked")
				List<Funcionario> funcionarios = query.getResultList();

				return funcionarios;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Funcionario Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT funcionario "//16
			        		+ "FROM Funcionario funcionario "
			        		+ "WHERE funcionario.id_funcionario = :Id");
	    	
			query.setParameter("Id", id);

			Funcionario funcionario = (Funcionario) query.getSingleResult();
			
		   return funcionario;
	   }
	   

		public boolean FuncionarioExiste(Funcionario funcionario) {
			// Pega o dado digitado pelo usuário
			String usuario = funcionario.getEmail_fun();
			String senha = funcionario.getSenha_fun();
						
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT fun FROM Funcionario as fun "
							+ "WHERE fun.usuario_funcionario = :usuario "
							+ "AND fun.senha_funcionario = :senha");

						query.setParameter("usuario", (String) usuario);
						query.setParameter("senha", (String) senha);
			
			@SuppressWarnings("unchecked")
			List<Funcionario> funcionarios = query.getResultList();
			
			if (!funcionarios.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
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
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Funcionario funcionario) {
			funcionario.setUpdated_at(cal.getTime());
			manager.merge(funcionario);
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
	    *			Método Restore			
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
