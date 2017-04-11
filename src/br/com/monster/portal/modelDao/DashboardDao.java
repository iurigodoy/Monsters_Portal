package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;

public interface DashboardDao {
	
	List<Pedido> Pedidos_por_semana();
	List<Cliente> Qtd_clientes();
	List<Cliente> Qtd_Clientes_Homens();
	List<Cliente> Qtd_Clientes_Mulheres();
	
}