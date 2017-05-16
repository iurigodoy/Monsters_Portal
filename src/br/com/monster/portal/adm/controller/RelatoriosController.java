package br.com.monster.portal.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Relatorio;
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

		 |==================================|
		 |				Métodos				|
		 |==================================|
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		// Página de relatórios
		@RequestMapping("Admin/Relatorios")
		public String Read(Model model, Relatorio relatorios) {
			model.addAttribute("relatorios", dao.Read());
			return "admin/relatorios"; 
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
		
		@RequestMapping("Admin/ProcurarRelatorios")
		public String Find(Model model, Long id) {
			model.addAttribute("relatorios", dao.Find_One(id));				//	Consulta o Banco e coloca na variável da página
			return "admin/relatorios";										//	Retorna para a página JSP relatorios
		}
	

}
