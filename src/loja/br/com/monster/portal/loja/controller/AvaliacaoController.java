package br.com.monster.portal.loja.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;

public class AvaliacaoController {

	@RequestMapping("CreateAvaliacao")
	public void CreateAvaliacao(Avaliacao avaliacao, Produto produto){
	}

	@RequestMapping("UpdateAvaliacao")
	public void UpdateAvaliacao(Avaliacao avaliacao, Produto produto){
	}

	@RequestMapping("DeleteAvaliacao")
	public void DeleteAvaliacao(long id){
	}

}