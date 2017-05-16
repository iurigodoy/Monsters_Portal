package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.ClienteDao;
import br.com.monster.portal.modelDao.PedidoDao;
import br.com.monster.portal.modelDao.ProdutoDao;
import br.com.monster.portal.carrinho.Carrinho;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class PedidoController {

	@Autowired
	PedidoDao dao;

	@Autowired
	ProdutoDao dao_prod;
	
	@Autowired
	ClienteDao dao_cli;
	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 *	1º Valida
	 *	2º Realiza ação no banco (criar)
	 *
	 *	@author Filipe A. Pimenta
	 *	@param Pedido - O Objeto principal para a criação
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */
	
	@RequestMapping("Admin/adicionar_pedido")
	public String create_page(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.read());
		model.addAttribute("produtos", dao_prod.read());
		model.addAttribute("clientes", dao_cli.read());
		return "admin/Pedido/adicionar";
	}
	
	@RequestMapping("Admin/CreatePedido")
	public String create(@Valid Pedido pedido, Carrinho carrinho, Cliente cliente, BindingResult result) {

		if(result.hasErrors()) {											//	Se houver erro na validação
		    return "forward:adicionar_pedido";								//	Volte para a página de adição
		} else {
			dao.create(pedido, carrinho, cliente);									//	Ação no banco
			return "redirect:adicionar_pedido";								//	Retorna para o método Read
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 *	1º Realiza ação no banco (ler)
	 *	2º Retorna para a página JSP
	 *
	 *	@author Filipe A. Pimenta
	 *	@return String - Página read (leitura)
	 */
	
	@RequestMapping("Admin/pedido")
	public String Read(Model model) {
		model.addAttribute("pedidos", dao.read());							//	Consulta o Banco e coloca na variável da página
		return "admin/Pedido/read";											//	Retorna para á página JSP
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 *	1º Valida
	 *	2º Realiza ação no banco (atualizar)
	 *	3º Retorna para o método READ
	 *
	 *	@author Filipe A. Pimenta
	 *	@param Pedido - O Objeto principal para a atualização
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */

	@RequestMapping("Admin/UpdatePedido")
	public String update(@Valid Pedido pedido, BindingResult result) {

		if(result.hasErrors()) {											//	Se houver erro na validação
		    return "forward:pedido";										//	Volte
		} else {
			dao.update(pedido);												//	Ação no banco
			return "redirect:pedido";										//	Retorna para o método Read
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 *	Requisição AJAX
	 *
	 *	1º Realiza ação no banco (excluir)
	 *
	 *	@author Filipe A. Pimenta
	 *	@param id Long - id do objeto a ser deletado
	 *	@return void - deletar não precisa de um retorno
	 */
	
	@RequestMapping("Admin/DeletePedido")
	public void delete(Long id) {
	  dao.delete(id);														//	Ação no banco
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 *	Requisição AJAX
	 *
	 *	1º Realiza ação no banco (restaurar)
	 *
	 *	@author Filipe A. Pimenta
	 *	@param id Long - id do objeto a ser restaurado (após ser deletado)
	 *	@return void - restaurar não precisa de um retorno
	 */
	
	@RequestMapping("Admin/RestorePedido")
	public void restore(Long id) {
		  dao.restore(id);													//	Ação no banco
	}


	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 *	Requisição AJAX
	 * 
	 *	1º Realiza consulta no Banco
	 *
	 *	@author Filipe A. Pimenta
	 *	@param id Long - id do objeto a ser deletado
	 *	@return String - retorna uma página JSP
	 */
	
	@RequestMapping("Admin/FindPedido")
	public String find(Model model, Long id) {
			model.addAttribute("pedido", dao.findOne(id));					//	Consulta o Banco e coloca na variável da página
			model.addAttribute("produtos", dao_prod.read());				//	Consulta o Banco e coloca na variável da página
			model.addAttribute("clientes", dao_cli.read());					//	Consulta o Banco e coloca na variável da página
			return "admin/Pedido/edt";										//	Retorna para a página JSP edt
	}
	
}