package br.com.monster.portal.modelDao;

import java.util.Date;
import java.util.List;

import br.com.monster.portal.model.Cliente;
<<<<<<< HEAD
import br.com.monster.portal.model.ProdutoMultiple;
=======
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
import br.com.monster.portal.model.Pedido;


public interface PedidoDao extends MetodosBasicos {
	
	List<Pedido> Read();
	
	List<Pedido> Find_By_Date(Date data_pedido);
	Object Find_pedido_boleto(String numb_ped);
	List<Pedido> Find_ped_cli(Cliente clienteInfo);
	
<<<<<<< HEAD
	void create(Pedido pedido, ProdutoMultiple produtos);
=======
	void create(Pedido pedido);
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
	void update(Pedido pedido);
	
}