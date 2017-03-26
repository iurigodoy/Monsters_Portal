package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Relatorios;

public interface RelatoriosDao {
	
	List<Relatorios> Read();
	List<Relatorios> Read_History();
	List<Relatorios> Select_Name_Id();
	Relatorios Find_One(Long id);
	
	void create(Relatorios relatorios);
	
}