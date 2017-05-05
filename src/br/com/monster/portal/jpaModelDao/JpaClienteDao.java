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
	    *			Mï¿½todo Read				
	    * ----------------------------------
	    * 
	    * A seguir mï¿½todos de pesquisa
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
	    *			Mï¿½todo Find_One			
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
				
				// Pega os resultados + senha já criptografada
			Cliente cliente = (Cliente) JpaResultHelper.getSingleResultOrNull(query);
			
			return cliente;
			
		}
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Mï¿½todo Create			
	    * ----------------------------------
	    * 
	    * A seguir mï¿½todos de alteraï¿½ï¿½o
	    * 
	    */
		public void create(Object objCliente) {
			Cliente cliente = (Cliente) objCliente;
			
			cliente.setSenha_cli(Cliente.criptografar_senha(cliente.getSenha_cli()));
			cliente.setCreated_at(cal.getTime());
			cliente.setUpdated_at(cal.getTime());
			cliente.setDeleted(false);
			 manager.persist(cliente);
	    }

	   /*
	    * ----------------------------------
	    *			Mï¿½todo Update			
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
	    *			Mï¿½todo Delete			
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
	    *			Mï¿½todo Restore			
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
