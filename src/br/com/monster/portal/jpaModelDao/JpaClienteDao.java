package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.ClienteDao;


// Container do Spring
@Repository
public class JpaClienteDao implements ClienteDao {

	
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
		public List<Cliente> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT cli "//16
			        		+ "FROM Cliente cli "
			        		+ "WHERE cli.deleted = false "
			        		+ "ORDER BY cli.id_cliente");

			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}
		   
		/*
		*	M�todo Read	History			
		*/
		public List<Cliente> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT cli "//16
			        		+ "FROM Cliente cli "
			        		+ "ORDER BY cli.id_cliente");

			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Cliente> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT cli.id_cliente, cli.cli_nome "//16
				        		+ "FROM Cliente cli "
				        		+ "WHERE cli.deleted = false "
				        		+ "ORDER BY cli.id_cliente");

				@SuppressWarnings("unchecked")
				List<Cliente> clientes = query.getResultList();

				return clientes;
			}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
			   
			   public Cliente Find_One(long id) {
					
					// Escreve a SQL
					Query query = manager
					        .createQuery("SELECT cli FROM Cliente cli "
					        		+ "WHERE cli.id_cliente = :Id "
					                + "ORDER BY nome_cliente DESC");
					
					query.setParameter("Id", (long) id);
			
						Cliente clientes = (Cliente) query.getSingleResult();
			
					return clientes;
					
				}
	   
	   public List<Cliente> Find_By_Name(String nome_cliente) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT cli FROM Cliente cli "
			        		+ "WHERE cli.nome_cliente LIKE :Nome "
			                + "ORDER BY nome_cliente DESC");
			
			query.setParameter("Nome", (String) "%"+nome_cliente+"%");
	
				@SuppressWarnings("unchecked")
				List<Cliente> clientes = query.getResultList();
	
			return clientes;
			
		}

		
		public boolean UsuarioExiste(Cliente cliente) {
			// Pega o dado digitado pelo usu�rio
			String usuario = cliente.getEmail_cli();
			String senha = cliente.getSenha_cli();
						
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT cli FROM Cliente as cli "
							+ "WHERE cli.email_cli = :usuario "
							+ "AND cli.senha_cli = :senha");
		
							query.setParameter("usuario", (String) usuario);
							query.setParameter("senha", (String) senha);

			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();
							
			if (!clientes.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
		
		public Cliente SeUsuarioExiste(Cliente cliente) {
			// Pega o dado digitado pelo usu�rio
			String usuario = cliente.getEmail_cli();
			String senha = cliente.getSenha_cli();
									
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT cli FROM Cliente as cli "
							+ "WHERE cli.email_cli = :usuario "
							+ "AND cli.senha_cli = :senha");
					
				query.setParameter("usuario", (String) usuario);
				query.setParameter("senha", (String) senha);

			Cliente cliente_result = (Cliente) query.getSingleResult();
	
			return cliente_result;
			
		}

		/*
		 * ---------------------
		 * 		Dashboard		
		 * ---------------------
		 */

		
		public List<Cliente> Qtd_clientes() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(cli.id_cliente) as count "
						+ "FROM Cliente as cli ");
						
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}

		
		public List<Cliente> Qtd_Clientes_Homens() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(cli.id_cliente) as count "
						+ "FROM Cliente as cli "
						+ "WHERE cli.sexo_cliente = :param");

			query.setParameter("param", (String) "true");
						
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}

		
		public List<Cliente> Qtd_Clientes_Mulheres() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(cli.id_cliente) as count "
						+ "FROM Cliente as cli "
						+ "WHERE cli.sexo_cliente = :param");

			query.setParameter("param", (String) "false");
						
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Cliente cliente) {
			cliente.setCreated_at(cal.getTime());
			cliente.setUpdated_at(cal.getTime());
			cliente.setDeleted(false);
			 manager.persist(cliente);
	    }

	   /*
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Cliente cliente) {
			cliente.setUpdated_at(cal.getTime());
			manager.merge(cliente);
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
				   .createQuery("UPDATE Cliente cli "
				   				+ "SET cli.deleted = true, "
				   				+ "cli.deleted_at = :Deleted_at "
   								+ "WHERE cli.id_cliente = :id");
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
				   .createQuery("UPDATE Cliente cliente "
				   				+ "SET cli.deleted = false "
   								+ "WHERE cli.id_cliente = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
}
