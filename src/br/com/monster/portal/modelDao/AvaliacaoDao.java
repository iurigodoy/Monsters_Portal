package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;

public interface AvaliacaoDao {
	
	List<Avaliacao> Read(Produto produto);
	List<Avaliacao> Read_History();
	List<Avaliacao> Select_Name_Id();
	Avaliacao Find_One(Long id);
	
	void create(Avaliacao avaliacao);
	void update(Avaliacao avaliacao);
	void delete(Long id);
	void restore(Long id);
	
}