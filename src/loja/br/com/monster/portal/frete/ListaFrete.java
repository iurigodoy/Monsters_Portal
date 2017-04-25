package br.com.monster.portal.frete;

public class ListaFrete {

	/*
	 * Segundo os Correios
	 * -------------------
	 * Array com os preços e prazos dos serviços solicitados e disponíveis.
	 */
	
	private String codigo;				// Código do Serviço de Entrega
	private String valor;				// Preço total da encomenda, em Reais, incluindo os preços dos serviços opcionais
	private String prazoEntrega;			// Prazo estimado em dias para entrega do produto. Se o valor retornado for 0 (zero), indica que o prazo não foi retornado corretamente.
	private String maoPropria;			// Preço do serviço adicional Mão Própria
	private String recebimento;			// Preço do serviço adicional Aviso de Recebimento
	private String valorDeclarado;		// Preço do serviço adicional Valor Declarado
	private String entregaDomiciliar;	// Informa se a localidade informada possui entrega domiciliária. Se o prazo não for retornado corretamente, o retorno deste parâmetro será vazio.
	private String entregaSabado;		// Informa se a localidade informada possui entrega domiciliária aos sábados. Se o prazo não for retornado corretamente, o retorno deste parâmetro será vazio
	private String erro;				// <Códigos de Erros retornados pelo calculador> + o código 7 (Serviço indisponível, tente mais tarde)
	private String msgErro;				// Retorna a descrição do erro gerado.
	
	// Getters And Setters ...
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public String getMaoPropria() {
		return maoPropria;
	}
	public void setMaoPropria(String maoPropria) {
		this.maoPropria = maoPropria;
	}
	public String getRecebimento() {
		return recebimento;
	}
	public void setRecebimento(String recebimento) {
		this.recebimento = recebimento;
	}
	public String getValorDeclarado() {
		return valorDeclarado;
	}
	public void setValorDeclarado(String valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	public String getEntregaDomiciliar() {
		return entregaDomiciliar;
	}
	public void setEntregaDomiciliar(String entregaDomiciliar) {
		this.entregaDomiciliar = entregaDomiciliar;
	}
	public String getEntregaSabado() {
		return entregaSabado;
	}
	public void setEntregaSabado(String entregaSabado) {
		this.entregaSabado = entregaSabado;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMsgErro() {
		return msgErro;
	}
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}

}
