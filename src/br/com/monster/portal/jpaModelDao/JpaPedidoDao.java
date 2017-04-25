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
import br.com.monster.portal.model.ListaProduto;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.model.Pedido_has_produto;
import br.com.monster.portal.model.Produto;
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
	    *			Mï¿½todo Read				
	    * ----------------------------------
	    * 
	    * A seguir mï¿½todos de pesquisa
	    * 
	    */
		public List<Pedido> read() {
			
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
	    * ----------------------------------
	    *			Mï¿½todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Pedido findOne(Long id) {
			
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
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Mï¿½todo Create			
	    * ----------------------------------
	    * 
	    * A seguir mï¿½todos de alteraï¿½ï¿½o
	    * 
	    */
		public void create(Pedido pedido, ListaProduto produtos) {
			pedido.setCreated_at(cal.getTime());
			pedido.setUpdated_at(cal.getTime());
			pedido.setDeleted(false);
			
			manager.persist(pedido);
			manager.flush();
			// Pega o Id do último dado inserido
			pedido.getId_pedido();

			// Checa se o array está correto e faz o laço de repetição
			if(null != produtos.getProdutos() && produtos.getProdutos().size() > 0) {
				for (Produto produto : produtos.getProdutos()) {
				  if(produto.getId_produto() != null && produto.getId_produto() != 0){

						// Segundo o Hibernate é necessário atualizar o objeto e pegar seu id novamente
						manager.merge(produto);
						manager.flush();
					
						Pedido_has_produto ped_prod = new Pedido_has_produto();
						ped_prod.setPedido(pedido);
						ped_prod.setProduto(produto);
						
						manager.persist(ped_prod);
						
				  }
				}
			}
	    }

	   /*
	    * ----------------------------------
	    *			Mï¿½todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Pedido pedido) {
			pedido.setUpdated_at(cal.getTime());
			manager.merge(pedido);
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
	    *			Mï¿½todo Restore			
	    * ----------------------------------
	    * 
	    */

	   public void restore(Long id) {
		   
		   Query query = manager
				   .createQuery("UPDATE Pedido pedido "
				   				+ "SET ped.deleted = false "
   								+ "WHERE ped.pedido = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }


	   
}
