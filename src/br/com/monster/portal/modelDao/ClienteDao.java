package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Cliente;

public interface ClienteDao extends MetodosBasicos, AutenticarDao {
	
	void create(Cliente cliente);
	void update(Object cliente);
	
}