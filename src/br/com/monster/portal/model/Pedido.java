package br.com.monster.portal.model;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue
	private Long id_pedido;
	
	@NotNull(message="{ped.numero.NotEmpty}")
	@Column(name = "ped_numero")			//Nome real dentro do banco
	private String numero_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.preco.NotEmpty}")
	@Column(name = "ped_preco")			//Nome real dentro do banco
	private Float preco_ped;			//Nome do campo no sistema
	

	@Column(name = "ped_custo_forma_de_pagamento")			//Nome real dentro do banco
	private Float custo_forma_de_pagamento_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.custo.frete.NotEmpty}")
	@Column(name = "ped_custo_frete")			//Nome real dentro do banco
	private Float custo_frete_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.parcelas.NotEmpty}")
	@Column(name = "ped_parcelas")			//Nome real dentro do banco
	private Integer parcelas_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.status.NotEmpty}")
	@Column(name = "ped_status")			//Nome real dentro do banco
	private Integer status_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.peso.NotEmpty}")
	@Size(min=2, max=20, message = "{ped.peso.Size}")
	@Column(name = "ped_peso")			//Nome real dentro do banco
	private String peso_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.altura.NotEmpty}")
	@Size(min=1, max=10, message = "{ped.altura.Size}")
	@Column(name = "ped_altura")			//Nome real dentro do banco
	private String altura_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.largura.NotEmpty}")
	@Size(min=1, max=10, message = "{ped.largura.Size}")
	@Column(name = "ped_largura")			//Nome real dentro do banco
	private String largura_ped;			//Nome do campo no sistema
	
	@NotNull(message="{ped.comprimento.NotEmpty}")
	@Size(min=1, max=10, message = "{ped.comprimento.Size}")
	@Column(name = "ped_comprimento")			//Nome real dentro do banco
	private String comprimento_ped;			//Nome do campo no sistema
	
	
	@Column(name = "ped_entrega_data")			//Nome real dentro do banco
	private Date entrega_data_ped;			//Nome do campo no sistema
	

	@Column(name = "ped_entrega_hora")			//Nome real dentro do banco
	private Time entrega_hora_ped;			//Nome do campo no sistema
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updated_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_at")
	private Date deleted_at;
	
	@Column(name = "deleted")
	private Boolean deleted;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	
	// MUITOS Ramais est�o em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "forma_pagamento_id_forma_pagamento", insertable=true, updatable=true)
	private Forma_pagamento forma_pagamento;
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="pedido", fetch=FetchType.EAGER)
	private Set<Pedido_has_produto> pedido_has_produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getNumero_ped() {
		return numero_ped;
	}

	public void setNumero_ped(String numero_ped) {
		this.numero_ped = numero_ped;
	}

	public Float getPreco_ped() {
		return preco_ped;
	}

	public void setPreco_ped(Float preco_ped) {
		this.preco_ped = preco_ped;
	}

	public Float getCusto_forma_de_pagamento_ped() {
		return custo_forma_de_pagamento_ped;
	}

	public void setCusto_forma_de_pagamento_ped(Float custo_forma_de_pagamento_ped) {
		this.custo_forma_de_pagamento_ped = custo_forma_de_pagamento_ped;
	}

	public Float getCusto_frete_ped() {
		return custo_frete_ped;
	}

	public void setCusto_frete_ped(Float custo_frete_ped) {
		this.custo_frete_ped = custo_frete_ped;
	}

	public Integer getParcelas_ped() {
		return parcelas_ped;
	}

	public void setParcelas_ped(Integer parcelas_ped) {
		this.parcelas_ped = parcelas_ped;
	}

	public Integer getStatus_ped() {
		return status_ped;
	}

	public void setStatus_ped(Integer status_ped) {
		this.status_ped = status_ped;
	}

	public String getPeso_ped() {
		return peso_ped;
	}

	public void setPeso_ped(String peso_ped) {
		this.peso_ped = peso_ped;
	}

	public String getAltura_ped() {
		return altura_ped;
	}

	public void setAltura_ped(String altura_ped) {
		this.altura_ped = altura_ped;
	}

	public String getLargura_ped() {
		return largura_ped;
	}

	public void setLargura_ped(String largura_ped) {
		this.largura_ped = largura_ped;
	}

	public String getComprimento_ped() {
		return comprimento_ped;
	}

	public void setComprimento_ped(String comprimento_ped) {
		this.comprimento_ped = comprimento_ped;
	}

	public Date getEntrega_data_ped() {
		return entrega_data_ped;
	}

	public void setEntrega_data_ped(Date entrega_data_ped) {
		this.entrega_data_ped = entrega_data_ped;
	}

	public Time getEntrega_hora_ped() {
		return entrega_hora_ped;
	}

	public void setEntrega_hora_ped(Time entrega_hora_ped) {
		this.entrega_hora_ped = entrega_hora_ped;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Forma_pagamento getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(Forma_pagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Set<Pedido_has_produto> getPedido_has_produto() {
		return pedido_has_produto;
	}

	public void setPedido_has_produto(Set<Pedido_has_produto> pedido_has_produto) {
		this.pedido_has_produto = pedido_has_produto;
	}
	
}
