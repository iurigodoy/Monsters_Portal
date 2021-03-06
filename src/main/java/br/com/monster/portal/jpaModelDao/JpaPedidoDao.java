package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.model.Pedido_has_produto;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;
import br.com.monster.portal.modelDao.PedidoDao;
import br.com.monster.portal.carrinho.Carrinho;

@Repository
public class JpaPedidoDao implements PedidoDao {
	
	@PersistenceContext
	EntityManager manager;

		public List<Object> read() {
	    	Query query = manager
			        .createQuery("SELECT ped "
			        		+ "FROM Pedido ped "
			        		+ "ORDER BY ped.created_at DESC");

			@SuppressWarnings("unchecked")
			List<Object> pedidos = query.getResultList();
			return pedidos;
		}
	   
	   public Pedido findOne(Long id) {
			Query query = manager
			        .createQuery("SELECT ped FROM Pedido ped "
			        		+ "WHERE ped.id_pedido = :Id ");
			query.setParameter("Id", id);
	
			Pedido pedidos = (Pedido) query.getSingleResult();
			return pedidos;
		}
	   
	   public Pedido findOneNoPay(Long id) {
			Query query = manager
			        .createQuery("SELECT ped FROM Pedido ped "
			        		+ "WHERE ped.id_pedido = :Id "
			        		+ "AND ped.status_ped = 0 ");
			query.setParameter("Id", id);
			
			Pedido pedidos = (Pedido) query.getSingleResult();
			return pedidos;
			
		}
	   
	   public List<Pedido> Find_By_Date(Date data_pedido) {
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

		public List<Pedido> Find_ped_cli(Long id) {
			Query query = manager
			        .createQuery("SELECT ped FROM Pedido ped "
			        		+ "WHERE ped.cliente.id_cliente = :Id ");
			query.setParameter("Id", id);
			
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}
	   
	   
		public Long create(Pedido pedido, Carrinho carrinho, Cliente cliente) {
			
			manager.merge(cliente);
			manager.flush();
			
			pedido.criarHistorico();
			
			manager.persist(pedido);
			manager.flush();
			// Pega o Id do �ltimo dado inserido
			pedido.getId_pedido();

			// Checa se o array est� correto e faz o la�o de repeti��o
			if(carrinho.getItens().size() > 0) {
				for (int i = 0; i < carrinho.getItens().size(); i++) {
					
				  // Melhorando a leitura com duas variaveis
				  Produto_has_fornecedor prod_forn = carrinho.getItens().get(i).getProduto_has_fornecedor();
				  Produto produto = prod_forn.getProduto();
				  
				  if(produto.getId_produto() != null && produto.getId_produto() != 0){

						// Segundo o Hibernate � necess�rio atualizar o objeto e pegar seu id novamente
						manager.merge(produto);
						manager.flush();
					
						Pedido_has_produto ped_prod = new Pedido_has_produto();
						
						ped_prod.setQuantidade_prod(prod_forn.getQuantidade_prod());
						ped_prod.setPreco_prod(prod_forn.getPreco_prod());
						ped_prod.setPedido(pedido);
						ped_prod.setProduto(produto);
						
						manager.persist(ped_prod);
						
				  }
				}
			}
			return pedido.getId_pedido();
	    }
		
		public void update(Object object) {
			Pedido pedido = (Pedido) object;
			pedido.atualizarHistorico();
			manager.merge(pedido);
		}

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Pedido ped "
				   				+ "SET ped.deleted = true, "
				   				+ "ped.deleted_at = :Deleted_at "
   								+ "WHERE ped.id_pedido = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Pedido ped "
				   				+ "SET ped.deleted = false "
   								+ "WHERE ped.id_pedido = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }

	public void create(Object object) {
		// TODO Auto-generated method stub
	}
	   
}
