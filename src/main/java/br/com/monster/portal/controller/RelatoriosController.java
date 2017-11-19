package br.com.monster.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.modelDao.RelatorioDao;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */
 
@Transactional
@Controller
public class RelatoriosController {
	
		// Consulta a interface RelatorioDao
		@Autowired
		RelatorioDao dao;
		
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
		
	@RequestMapping("Admin/ProcurarRelatorios/{id}")
	public String Find(Model model, @PathVariable("id") Long id) {
		model.addAttribute("relatorios", dao.Find_One(id));		//	Consulta o Banco e coloca na variável da página
		return "admin/Funcionario/relatorio";					//	Retorna para a página JSP relatorios
	}
}
