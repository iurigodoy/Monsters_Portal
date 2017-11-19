package br.com.monster.portal.security;

import javax.servlet.http.HttpSession;

import br.com.monster.portal.model.Permissao;

public class Permissoes {
	public static boolean checar(HttpSession session, EnumMetodo metodo, EnumEntidade entidade){
		
		// Pega a permiss�o do usu�rio pela sess�o
		Permissao permissao = (Permissao) session.getAttribute("permissao");
		
		if(EnumEntidade.BANNER == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerBanner()){			return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarBanner()){			return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarBanner()){		return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirBanner()){		return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarBanner()){		return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.CARGO == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerCargo()){			return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarCargo()){			return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarCargo()){		return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirCargo()){		return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarCargo()){		return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.CATEGORIA == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerCategoria()){		return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarCategoria()){		return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarCategoria()){	return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirCategoria()){	return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarCategoria()){	return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.CLIENTE == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerCliente()){			return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarCliente()){		return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarCliente()){	return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirCliente()){		return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarCliente()){	return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.FORNECEDOR == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerFornecedor()){		return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarFornecedor()){		return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarFornecedor()){	return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirFornecedor()){	return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarFornecedor()){	return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.FUNCIONARIO == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerFuncionario()){		return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarFuncionario()){	return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarFuncionario()){return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirFuncionario()){	return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarFuncionario()){return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.PEDIDO == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerPedido()){			return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarPedido()){			return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarPedido()){		return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirPedido()){		return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarPedido()){		return true; } else { return false ; } } else { return false; }
		}
		if(EnumEntidade.PRODUTO == entidade){
			if(EnumMetodo.LER		==	metodo){ if(permissao.isLerProduto()){			return true; } else { return false ; } }
			if(EnumMetodo.CRIAR		==	metodo){ if(permissao.isCriarProduto()){		return true; } else { return false ; } }
			if(EnumMetodo.ATUALIZAR	==	metodo){ if(permissao.isAtualizarProduto()){	return true; } else { return false ; } }
			if(EnumMetodo.EXCLUIR	==	metodo){ if(permissao.isExcluirProduto()){		return true; } else { return false ; } }
			if(EnumMetodo.RESTAURAR ==	metodo){ if(permissao.isRestaurarProduto()){	return true; } else { return false ; } } else { return false; }
		}
		return false;
	}
}
