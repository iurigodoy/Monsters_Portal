package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.modelDao.ImagemDao;
@Transactional
@Controller
public class ImagemController {
	


		@Autowired
		ImagemDao dao;
		
		/*

		 |==================================|
		 |				Métodos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Createimagem")
		public String create(@Valid Imagem imagem, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Produto";
			} else {
				dao.create(imagem);
				return "redirect:Produto";
			}
			
		}
		
		
		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Imagem")
		public String Read(Model model, Imagem imagem) {
			model.addAttribute("imagems", dao.Read());
			return "admin/Imagem";
		}


		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/Updateimagem")
		public String update(@Valid Imagem imagem, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Produto";
			} else {
				dao.update(imagem);
				return "redirect:Produto";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Deleteimagem")
		public String delete(Long id) {
		  dao.delete(id);
		  return "redirect:Produto";
		}
		
		/*
		 * -------------------------
		 * 			Restore			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/RestoreImagem")
		public String restore(Long id) {
			  dao.restore(id);
			  return "delete";
		}

		/*
		 * -------------------------
		 * 			Find			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/ProcurarImagem")
		public String Find(Model model, Long id) {
		model.addAttribute("imagems", dao.Find_One(id));
		return "admin/Imagem";
	}

}
