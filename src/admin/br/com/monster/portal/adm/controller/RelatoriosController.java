package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Relatorio;
import br.com.monster.portal.modelDao.RelatorioDao;

@Transactional
@Controller
public class RelatoriosController {
	

		@Autowired
		RelatorioDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Createrelatorios")
		public String create(@Valid Relatorio relatorios, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Funcionario";
			} else {
				dao.create(relatorios);
				return "redirect:Funcionario";
			}
			
		}
		
		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Relatorios")
		public String Read(Model model, Relatorio relatorios) {
			model.addAttribute("relatorios", dao.Read());
			return "admin/relatorios"; 
		}

		
		/*
		 * -------------------------
		 * 			Find			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/ProcurarRelatorios")
		public String Find(Model model, Long id) {
			model.addAttribute("relatorios", dao.Find_One(id));
			return "admin/relatorios";
		}
	

}
