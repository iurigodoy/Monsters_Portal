package br.com.monster.portal.security;

public enum EnumPermissao {
	LER(1), CRIAR(2), ATUALIZAR(3), EXCLUIR(4), RESTAURAR(5);
	
	private final int permissao;
	EnumPermissao(int permissaoSelecionada){
		permissao = permissaoSelecionada;
	}
	public int getPermissao(){
		return permissao;
	}
}
