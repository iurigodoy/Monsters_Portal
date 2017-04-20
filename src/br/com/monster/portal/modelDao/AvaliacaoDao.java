package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;

public interface AvaliacaoDao extends MetodosBasicos {
	List<Avaliacao> read(Produto produto);
	void create(Avaliacao avaliacao);
	void update(Avaliacao avaliacao);
	
}