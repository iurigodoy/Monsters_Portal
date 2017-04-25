package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Relatorio;

public interface RelatorioDao {
	
	List<Relatorio> Read();
	Relatorio Find_One(Long id);
	
	void create(Relatorio relatorios);
	
}