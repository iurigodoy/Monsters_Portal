package br.com.monster.portal.modelDao;

public interface ClienteDao extends MetodosBasicos, AutenticarDao {
	
	void create(Object cliente);
	void update(Object cliente);
	
}