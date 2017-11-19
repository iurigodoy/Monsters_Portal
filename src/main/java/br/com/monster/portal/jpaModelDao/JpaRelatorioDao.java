package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.model.Relatorio;
import br.com.monster.portal.modelDao.RelatorioDao;
import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;

@Repository
public class JpaRelatorioDao implements RelatorioDao {
	
	@PersistenceContext
	EntityManager manager;
	   
	   public List<Relatorio> Find_One(Long id){
	    	Query query = manager
			        .createQuery("SELECT relatorios "//16
			        		+ "FROM Relatorio relatorios "
			        		+ "WHERE relatorios.funcionario.id_funcionario = :Id "
			        		+ "ORDER BY relatorios.created_at DESC");
	    	
			query.setParameter("Id", id);

			@SuppressWarnings("unchecked")
			List<Relatorio> relatorios = (List<Relatorio>) query.getResultList();
			
		   return relatorios;
	   }
	   
	public void gerarRelatorio(HttpSession session, EnumMetodo metodo, EnumEntidade entidade) {
		Relatorio relatorio = new Relatorio();
		Funcionario funcionario = (Funcionario) session.getAttribute("administradorLogado");

		relatorio.setFuncionario(funcionario);
		relatorio.setMetodo(metodo);
		relatorio.setEntidade(entidade);
		relatorio.setCreated_at(Calendar.getInstance());
		manager.persist(relatorio);
	}
}
