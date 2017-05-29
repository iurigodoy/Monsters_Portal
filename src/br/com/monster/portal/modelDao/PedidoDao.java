package br.com.monster.portal.modelDao;

import java.util.Date;
import java.util.List;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.carrinho.Carrinho;


public interface PedidoDao extends MetodosBasicos {
	
	List<Pedido> Find_By_Date(Date data_pedido);
	Object Find_pedido_boleto(String numb_ped);
	List<Pedido> Find_ped_cli(Long id_cliente);
	Pedido findOneNoPay(Long id);
	
	Long create(Pedido pedido, Carrinho carrinho, Cliente cliente);
	void update(Pedido pedido);
	
}