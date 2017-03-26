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
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.PedidoDao;



// Container do Spring
@Repository
public class JpaPedidoDao implements PedidoDao {

	
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
		public List<Pedido> Read() {
			
		    	/*Query query = manager
				        .createQuery("SELECT ped "
			        			+ "FROM Pedido ped, Produto prod, pedido_has_produto pedprod "
			        			+ "WHERE pedprod.pedido_id_pedido = ped.id_pedido "
			        			+ "AND pedprod.produto = prod.produto");*/
			
	    	Query query = manager
			        .createQuery("SELECT ped "
			        		+ "FROM Pedido ped INNER JOIN ped.cliente cli "
			        		+ "WHERE ped.deleted = false "
			        		+ "ORDER BY ped.data_pedido DESC");

			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Pedido> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT ped "
				        		+ "FROM Pedido ped "
				        		+ "ORDER BY ped.data_pedido ASC");

			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Pedido> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT ped.id_pedido, pro.pro_nome "//16
				        		+ "FROM Pedido ped "
				        		+ "WHERE ped.deleted = false "
				        		+ "ORDER BY data_pedido");

				@SuppressWarnings("unchecked")
				List<Pedido> pedidos = query.getResultList();

				return pedidos;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Pedido Find_One(long id) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT ped FROM Pedido ped "
			        		+ "WHERE ped.id_pedido = :Id ");
			
			query.setParameter("Id", id);
	
				Pedido pedidos = (Pedido) query.getSingleResult();
	
			return pedidos;
			
		}
	   
	   public List<Pedido> Find_By_Date(Date data_pedido) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT ped FROM Pedido ped "
			        		+ "WHERE ped.data_pedido = :Date "
			                + "ORDER BY ped.data_pedido ASC");
			
			query.setParameter("Date", (Date) data_pedido);
	
				@SuppressWarnings("unchecked")
				List<Pedido> pedidos = query.getResultList();
	
			return pedidos;
			
		}

		public Object Find_pedido_boleto(String numb_ped) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT ped "
			        			+ "FROM Pedido ped INNER JOIN ped.cliente cli "
			        			+ "WHERE ped.cliente = cli.id_cliente "
			        			+ "AND ped.numero_pedido = :Numero "
			        			+ "ORDER BY ped.data_pedido DESC");
			query.setParameter("Numero", numb_ped);
			
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

		return pedidos;
		}

		public List<Pedido> Find_ped_cli(Cliente clienteInfo) {


			System.out.print("------------------------------------------------------- " + clienteInfo + " ---------------------------------------------------------------------------");
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT t FROM Pedido as t "
			        		+ "WHERE t.cliente = :Id "
			                + "ORDER BY t.id_pedido ASC");
			query.setParameter("Id", clienteInfo);
			
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}

		public List<Pedido> Pedidos_por_semana() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(ped.id_pedido) as count, ped.data_pedido "
						+ "FROM Pedido as ped "
						+ "WHERE ped.data_pedido BETWEEN CURRENT_DATE -7 AND CURRENT_DATE "
						+ "GROUP BY ped.data_pedido "
						+ "ORDER BY ped.data_pedido");
						
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Pedido pedido) {
			pedido.setCreated_at(cal.getTime());
			pedido.setUpdated_at(cal.getTime());
			pedido.setDeleted(false);
			 manager.persist(pedido);
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Pedido pedido) {
			pedido.setUpdated_at(cal.getTime());
			manager.merge(pedido);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(long id) {
		   
		   Date datetime = cal.getTime();
		   
		   Query query = manager
				   .createQuery("UPDATE Pedido ped "
				   				+ "SET ped.deleted = true, "
				   				+ "ped.deleted_at = :Deleted_at "
   								+ "WHERE ped.id_pedido = :id");
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

	   public void restore(long id) {
		   
		   Query query = manager
				   .createQuery("UPDATE Pedido pedido "
				   				+ "SET ped.deleted = false "
   								+ "WHERE ped.pedido = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }


	   
}
