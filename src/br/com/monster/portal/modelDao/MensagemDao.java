package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Mensagem;

public interface MensagemDao {
	
	List< Mensagem> Read();
	List< Mensagem> Read_History();
	List< Mensagem> Select_Name_Id();
	 Mensagem Find_One(Long id);
	
	void create( Mensagem mensagem);
	void update( Mensagem mensagem);
	void delete(Long id);
	void restore(Long id);
	
}