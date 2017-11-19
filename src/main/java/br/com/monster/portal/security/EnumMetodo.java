package br.com.monster.portal.security;

public enum EnumMetodo {
	LER(1), CRIAR(2), ATUALIZAR(3), EXCLUIR(4), RESTAURAR(5);
	
	private final int metodo;
	EnumMetodo(int metodoSelecionado){
		metodo = metodoSelecionado;
	}
	public int getMetodo(){
		return metodo;
	}
}
