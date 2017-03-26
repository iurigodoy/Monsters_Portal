package br.com.monster.portal.loja.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;

public class AvaliacaoController {

	@RequestMapping("CreateAvaliacao")
	public String CreateAvaliacao(Avaliacao avaliacao, Produto produto){
		String nome_produto = produto.getNome_pro();
	    return "/Produtos/" + nome_produto;
	}

}
