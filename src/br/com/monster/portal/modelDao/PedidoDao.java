package br.com.monster.portal.modelDao;

import java.util.Date;
import java.util.List;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;


public interface PedidoDao {
	
	List<Pedido> Read();
	Pedido Find_One(long id);
	
	List<Pedido> Find_By_Date(Date data_pedido);
	Object Find_pedido_boleto(String numb_ped);
	List<Pedido> Find_ped_cli(Cliente clienteInfo);
	
	void create(Pedido pedido);
	void update(Pedido pedido);
	void delete(long id);
	void restore(long id);
	
}