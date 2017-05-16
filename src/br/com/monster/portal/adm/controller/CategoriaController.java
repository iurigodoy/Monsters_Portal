package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class CategoriaController {
	

		@Autowired
		CategoriaDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 *	2º Valida
		 *	3º Realiza ação no banco (criar)
		 *
		 *	@author Filipe A. Pimenta
		 *	@param Categoria - O Objeto principal para a criação
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */
		
		@RequestMapping("Admin/CreateCategoria")
		public String create(@Valid Categoria categoria, BindingResult result) {			
			if(result.hasErrors()) {														//	Se houver erro na validação
			    return "forward:categoria";													//	Volte para a página categoria
			} else {
				dao.create(categoria);														//	Ação no banco
				return "redirect:categoria";												//	Retorna para o método Read
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
		
		@RequestMapping("Admin/categoria")
		public String Read(Model model) {
			model.addAttribute("categorias", dao.read());									//	Consulta o Banco e coloca na variável da página
			return "admin/Categoria/read";												//	Retorna para á página JSP
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
		 *	@param Categoria - O Objeto principal para a atualização
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */

		@RequestMapping("Admin/UpdateCategoria")
		public String update(@Valid Categoria categoria, BindingResult result) {
			if(result.hasErrors()) {														//	Se houver erro na validação
			    return "forward:categoria";													//	Volte
			} else {
				dao.update(categoria);														//	Ação no banco
				return "redirect:categoria";												//	Retorna para o método Read
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
		
		@RequestMapping("Admin/DeleteCategoria")
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
		
		@RequestMapping("Admin/RestoreCategoria")
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
		
		@RequestMapping("Admin/FindCategoria")
		public String find_one(Long id, Model model) {
		  model.addAttribute("categorias", dao.findOne(id));								//	Consulta o Banco e coloca na variável da página
		  return "admin/Categoria/edt";														//	Retorna para a página JSP edt
		}
		
}
