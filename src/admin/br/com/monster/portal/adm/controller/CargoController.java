package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.modelDao.CargoDao;
@Transactional
@Controller
public class CargoController {
	


		@Autowired
		CargoDao dao;
		
		/*

		 |==================================|
		 |				M�todos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Createcargo")
		public String create(@Valid Cargo cargo, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Funcionario";
			} else {
				dao.create(cargo);
				return "redirect:Funcionario";
			}
			
		}

		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Cargo")
		public String Read(Model model) {
			model.addAttribute("cargos", dao.Read());
			return "admin/Funcionario/cargo";
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/Updatecargo")
		public String update(@Valid Cargo cargo, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Funcionario";
			} else {
				dao.update(cargo);
				return "redirect:Funcionario";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Deletecargo")
		public String delete(Long id) {
		  dao.delete(id);
		  return "redirect:Funcionario";
		}
		
		/*
		 * -------------------------
		 * 			Restore			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Restorecargo")
		public String restore(Long id) {
			  dao.restore(id);
			  return "delete";
		}

		/*
		 * -------------------------
		 * 			Find			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Find_Cargo")
		public String find_one(Long id, Model model) {
		  model.addAttribute("cargos", dao.findOne(id));
		  return "admin/cargo";
		}
}
