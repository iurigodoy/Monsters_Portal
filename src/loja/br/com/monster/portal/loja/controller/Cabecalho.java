package br.com.monster.portal.loja.controller;

import org.springframework.ui.Model;

import br.com.monster.portal.modelDao.CategoriaDao;

public class Cabecalho {
	
	CategoriaDao dao_cat;
	
	public Model categoria(Model model) {
		model.addAttribute("categorias", dao_cat.Read());
		return model;
	}
}
