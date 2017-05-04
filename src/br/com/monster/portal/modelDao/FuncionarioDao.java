package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.model.Permissao;

public interface FuncionarioDao extends MetodosBasicos {
	
	List<Funcionario> Read();
	boolean FuncionarioExiste(Funcionario funcionario);
	
	void create(Funcionario funcionario);
	void update(Funcionario funcionario);
	Permissao getPermissao(Long id);
}