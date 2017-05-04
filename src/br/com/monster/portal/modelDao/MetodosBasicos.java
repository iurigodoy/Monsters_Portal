package br.com.monster.portal.modelDao;

public interface MetodosBasicos {
	Object findOne(Long id);
	void delete(Long id);
	void restore(Long id);
}