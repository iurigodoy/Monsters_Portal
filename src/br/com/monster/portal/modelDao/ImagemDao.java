package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Imagem;

public interface ImagemDao {
	
	List<Imagem> Read();
	List<Imagem> Read_History();
	List<Imagem> Select_Name_Id();
	Imagem Find_One(Long id);
	
	void create(Imagem imagem);
	void update(Imagem imagem);
	void delete(Long id);
	void restore(Long id);
	
}