package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Funcionario;

public interface FuncionarioDao extends MetodosBasicos, AutenticarDao {
	void create(Funcionario funcionario);
	void update(Funcionario funcionario);
}