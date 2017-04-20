package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.DashboardDao;



// Container do Spring
@Repository
public class JpaDashboardDao implements DashboardDao {

	
	@PersistenceContext
	EntityManager manager;
	


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
   
	   
}
