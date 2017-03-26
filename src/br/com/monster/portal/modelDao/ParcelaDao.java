package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Parcela;

public interface ParcelaDao {
	
	List<Parcela> Read();
	List<Parcela> Read_History();
	List<Parcela> Select_Name_Id();
	Parcela Find_One(Long id);
	
	void create(Parcela parcela);
	void update(Parcela parcela);
	void delete(Long id);
	void restore(Long id);
	
}