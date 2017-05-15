package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.ClienteDao;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class ClienteController {

	@Autowired
	ClienteDao dao;
	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|


	/*
	 * -------------------------
	 * 			Create			
	 * -------------------------
	 *	1º Valida
	 *	2º Realiza ação no banco (criar)
	 *
	 *	@author Filipe A. Pimenta
	 *	@param Cliente - O Objeto principal para a criação
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */
	
	@RequestMapping("Admin/adicionar_cliente")
	public String create_page(Model model) {
		model.addAttribute("clie_page", "active");
		model.addAttribute("clientes", dao.read());
		return "admin/Cliente/adicionar";
	}
	
	@RequestMapping("Admin/CreateCliente")
	public String createAdmin(@Valid Cliente cliente, BindingResult result) {			
		if(result.hasErrors()) {														//	Se houver erro na validação
		    return "forward:adicionar_cliente";											//	Volte para a página de adição
		} else {
			dao.create(cliente);														//	Ação no banco
			return "redirect:cliente";													//	Retorna para o método Read
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
	
	@RequestMapping("Admin/cliente")
	public String Read(Model model) {
		model.addAttribute("clientes", dao.read());										//	Consulta o Banco e coloca na variável da página
		return "admin/Cliente/read";													//	Retorna para á página JSP
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
	 *	@param Cliente - O Objeto principal para a atualização
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */

	@RequestMapping("UpdateCliente")
	public String update(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {														//	Se houver erro na validação
		    return "forward:MinhaConta";												//	Volte
		} else {
			dao.update(cliente);														//	Ação no banco
			return "redirect:MinhaConta";												//	Retorna para o método Read
		}
	}

	@RequestMapping("/Admin/UpdateCliente")
	public String updateAdmin(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {														//	Se houver erro na validação
		    return "forward:Cliente";													//	Volte
		} else {
			dao.update(cliente);														//	Ação no banco
			return "redirect:Cliente";													//	Retorna para o método Read
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
	
	@RequestMapping("Admin/DeleteCliente")
	public void bloquear(Cliente cliente) {
	  //dao.delete(cliente);															//	Ação no banco
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
	
	@RequestMapping("Admin/RestoreCliente")
	public void restore(Long id) {
		dao.restore(id);																//	Ação no banco
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
	
	@RequestMapping("Admin/FindCliente")
	public String find_one(Long id, Model model) {
	  model.addAttribute("clientes", dao.findOne(id));									//	Consulta o Banco e coloca na variável da página
	  return "admin/Cliente/edt";														//	Retorna para a página JSP edt
	}
	
}
