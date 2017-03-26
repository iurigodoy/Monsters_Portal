package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Funcionario;

public interface FuncionarioDao {
	
	List<Funcionario> Read();
	List<Funcionario> Read_History();
	List<Funcionario> Select_Name_Id();
	Funcionario Find_One(Long id);
	
	void create(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Long id);
	void restore(Long id);
	boolean FuncionarioExiste(Funcionario funcionario);
}