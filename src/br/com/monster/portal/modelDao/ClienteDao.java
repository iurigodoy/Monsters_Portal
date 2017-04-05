package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Cliente;

public interface ClienteDao {
	
	List<Cliente> Read();
	List<Cliente> Read_History();
	List<Cliente> Select_Name_Id();
	Cliente Find_One(long id);
	
	void create(Cliente cliente);
	void update(Cliente cliente);
	void delete(Long id);
	void restore(Long id);
	
	
	List<Cliente> Find_By_Name(String nome_cliente);
	boolean UsuarioExiste(Cliente cliente);
	Cliente SeUsuarioExiste(Cliente cliente);
	

	List<Cliente> Qtd_clientes();
	List<Cliente> Qtd_Clientes_Homens();
	List<Cliente> Qtd_Clientes_Mulheres();
}