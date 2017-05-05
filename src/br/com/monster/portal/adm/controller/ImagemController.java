package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
		 |				M�todos				|
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

}
