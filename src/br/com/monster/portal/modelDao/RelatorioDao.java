package br.com.monster.portal.modelDao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.monster.portal.model.Relatorio;
import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;

public interface RelatorioDao {

	List<Relatorio> Find_One(Long id);
	
	void gerarRelatorio(HttpSession session, EnumMetodo metodo, EnumEntidade entidades);
	
}