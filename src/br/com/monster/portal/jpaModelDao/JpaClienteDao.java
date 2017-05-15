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
import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.ClienteDao;
import br.com.monster.portal.security.Crypt;


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
		public List<Cliente> read() {
			
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
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
			   
			   public Cliente findOne(Long id) {
					
					// Escreve a SQL
					Query query = manager
					        .createQuery("SELECT cli FROM Cliente cli "
					        		+ "WHERE cli.id_cliente = :Id "
					                + "ORDER BY nome_cliente DESC");
					
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
						
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT cli FROM Cliente as cli "
						
							+ "WHERE cli.email_cli = :email "
							+ "AND cli.senha_cli = :senha");
		
							query.setParameter("email", email);
							query.setParameter("senha", senha);
				
				// Pega os resultados + senha j� criptografada
			Cliente cliente = (Cliente) JpaResultHelper.getSingleResultOrNull(query);
			
			return cliente;
			
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

			Crypt crypt = new Crypt();
			
			cliente.setSenha_cli(crypt.criptografar(cliente.getSenha_cli()));
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
		public void update(Object objCliente) {
			Cliente cliente = (Cliente) objCliente;
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
