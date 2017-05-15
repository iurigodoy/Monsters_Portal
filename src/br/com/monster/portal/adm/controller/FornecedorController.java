package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.modelDao.FornecedorDao;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class FornecedorController {

	@Autowired
	FornecedorDao dao;
	
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
	 *	@param Fornecedor - O Objeto principal para a criação
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */
	
	@RequestMapping("Admin/CreateFornecedor")
	public String create(@Valid Fornecedor fornecedor, BindingResult result) {			
		if(result.hasErrors()) {														//	Se houver erro na validação
		    return "forward:fornecedor";												//	Volte para a página fornecedor
		} else {
			dao.create(fornecedor);														//	Ação no banco
			return "redirect:fornecedor";												//	Retorna para o método Read
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
	
	@RequestMapping("Admin/fornecedor")
	public String Read(Model model) {
		model.addAttribute("fornecedores", dao.read());									//	Consulta o Banco e coloca na variável da página
		return "admin/Fornecedor/read";													//	Retorna para á página JSP
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
	 *	@param Fornecedor - O Objeto principal para a atualização
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */

	@RequestMapping("Admin/UpdateFornecedor")
	public String update(@Valid Fornecedor fornecedor, BindingResult result) {
		if(result.hasErrors()) {														//	Se houver erro na validação
		    return "forward:fornecedor";												//	Volte
		} else {
			dao.update(fornecedor);														//	Ação no banco
			return "redirect:fornecedor";												//	Retorna para o método Read
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
	
	@RequestMapping("Admin/DeleteFornecedor")
	public void delete(Long id) {
	  dao.delete(id);																	//	Ação no banco
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
	
	@RequestMapping("Admin/RestoreFornecedor")
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
	
	@RequestMapping("Admin/FindFornecedor")
	public String Find(Model model, Long id) {
		model.addAttribute("fornecedores", dao.findOne(id));							//	Consulta o Banco e coloca na variável da página
		return "admin/Fornecedor/edt";													//	Retorna para a página JSP edt
	}

}
