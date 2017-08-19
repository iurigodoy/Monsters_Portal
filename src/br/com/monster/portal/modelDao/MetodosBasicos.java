package br.com.monster.portal.modelDao;

import java.util.List;

public interface MetodosBasicos {
	// CRUD
	List<Object> read();
	void create(Object object);
	void update(Object object);
	void delete(Long id);
	// Adicionais
	Object findOne(Long id);
	void restore(Long id);
	
}