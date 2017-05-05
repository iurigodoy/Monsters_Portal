package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.GregorianCalendar;
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



// Container do Spring
@Repository
public class JpaRelatorioDao implements RelatorioDao {

	
	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
	   
	   /*
	    * ----------------------------------
	    *			M�todo Read				
	    * ----------------------------------
	    * 
	    * A seguir m�todos de pesquisa
	    * 
	    */
		public List<Relatorio> Read() {
			
				/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Relatorios pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_relatorios ASC");

			@SuppressWarnings("unchecked")
			List<Relatorio> relatorios = query.getResultList();

			return relatorios;
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Relatorio Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT relatorios "//16
			        		+ "FROM Relatorios relatorios "
			        		+ "WHERE relatorios.id_relatorios = :Id");
	    	
			query.setParameter("Id", id);

			Relatorio relatorios = (Relatorio) query.getSingleResult();
			
		   return relatorios;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void gerarRelatorio(HttpSession session, EnumMetodo metodo, EnumEntidade entidade) {
			Relatorio relatorio = new Relatorio();
			Funcionario funcionario = (Funcionario) session.getAttribute("administradorLogado");
			
			relatorio.setFuncionario(funcionario);
			relatorio.setMetodo(metodo);
			relatorio.setEntidade(entidade);
			relatorio.setCreated_at(cal.getTime());
			manager.persist(relatorio);
	    }
	   
}
