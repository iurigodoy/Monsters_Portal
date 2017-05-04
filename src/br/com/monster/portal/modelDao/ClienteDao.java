package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Cliente;

public interface ClienteDao extends MetodosBasicos {
	
	List<Cliente> Read();
	Cliente SeUsuarioExiste(Cliente cliente);
	boolean UsuarioExiste(Cliente cliente);
	
	void create(Cliente cliente);
	void update(Cliente cliente);
	
}