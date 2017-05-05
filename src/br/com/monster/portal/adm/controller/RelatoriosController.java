package br.com.monster.portal.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
		 |				M�todos				|
		 |==================================|
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
