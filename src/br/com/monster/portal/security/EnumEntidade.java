package br.com.monster.portal.security;

public enum EnumEntidade {
	BANNER(1),CARGO(2),CATEGORIA(3),CLIENTE(4),
	FORNECEDOR(5),FUNCIONARIO(6),PEDIDO(7),PRODUTO(8);
	
	private final int entidade;
	EnumEntidade(int entidadeSelecionada){
		entidade = entidadeSelecionada;
	}
	public int getEntidade(){
		return entidade;
	}
}
