package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Acesso;

public interface AcessoDao {
	
	List< Acesso> Read();
	List< Acesso> Read_History();
	List< Acesso> Select_Name_Id();
	 Acesso Find_One(Long id);
	
	void create( Acesso acesso);
	void update( Acesso acesso);
	void delete(Long id);
	void restore(Long id);
	
}