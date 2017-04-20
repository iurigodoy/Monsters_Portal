package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Acesso;

public interface AcessoDao {
	
	List< Acesso> Read();
	
	void create( Acesso acesso);
	
}