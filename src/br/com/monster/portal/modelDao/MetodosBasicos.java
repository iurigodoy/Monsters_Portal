package br.com.monster.portal.modelDao;

import java.util.List;

public interface MetodosBasicos {
	
	List<?> read();
	//void create(Object object);
	//void update(Object object);
	
	Object findOne(Long id);
	void delete(Long id);
	void restore(Long id);
	
}