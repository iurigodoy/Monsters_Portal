package br.com.monster.portal.model;

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

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue
	private Long id_pedido;
	
	@NotNull(message="{ped.numero.NotEmpty}")
	@Column(name = "ped_numero")						//Nome real dentro do banco
	private int numero_ped;								//Nome do campo no sistema
	
	@NotNull(message="{ped.preco.NotEmpty}")
	@Column(name = "ped_preco")							//Nome real dentro do banco
	private Double preco_ped = 0.00;					//Nome do campo no sistema
	

	@Column(name = "ped_custo_forma_de_pagamento")		//Nome real dentro do banco
	private Double custo_forma_de_pagamento_ped = 0.00;	//Nome do campo no sistema
	
	@NotNull(message="{ped.custo.frete.NotEmpty}")
	@Column(name = "ped_custo_frete")					//Nome real dentro do banco
	private Double custo_frete_ped = 0.00;				//Nome do campo no sistema
	
	@NotNull(message="{ped.status.NotEmpty}")
	@Column(name = "ped_status")						//Nome real dentro do banco
	private Integer status_ped;							//	0 = não foi efetuado o pagamento,
														//	1 = efetuado o pagamento, esperando entrega
														//	2 = entrega efetuada, pedido finalizado
														//	3 = cancelado
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ped_entrega_data")					//Nome real dentro do banco
	private Date data_entrega_ped;						//Nome do campo no sistema
	
	
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="pedido")
	private Set<Pedido_has_produto> pedido_has_produto;
	
	public Double getPreco_total(Double preco_ped, Double custo_forma_de_pagamento_ped, Double custo_frete_ped){
		Double precoTotal = preco_ped + custo_forma_de_pagamento_ped + custo_frete_ped;
		return precoTotal;
	}
	
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

	public int getNumero_ped() {
		return numero_ped;
	}

	public void setNumero_ped(int numb_ped) {
		this.numero_ped = numb_ped;
	}

	public Double getPreco_ped() {
		return preco_ped;
	}

	public void setPreco_ped(Double preco_ped) {
		this.preco_ped = preco_ped;
	}

	public Double getCusto_forma_de_pagamento_ped() {
		return custo_forma_de_pagamento_ped;
	}

	public void setCusto_forma_de_pagamento_ped(Double custo_forma_de_pagamento_ped) {
		this.custo_forma_de_pagamento_ped = custo_forma_de_pagamento_ped;
	}

	public Double getCusto_frete_ped() {
		return custo_frete_ped;
	}

	public void setCusto_frete_ped(Double custo_frete_ped) {
		this.custo_frete_ped = custo_frete_ped;
	}

	public Integer getStatus_ped() {
		return status_ped;
	}

	public void setStatus_ped(Integer status_ped) {
		this.status_ped = status_ped;
	}

	public Date getData_entrega_ped() {
		return data_entrega_ped;
	}

	public void setData_entrega_ped(Date data_entrega_ped) {
		this.data_entrega_ped = data_entrega_ped;
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

	public Set<Pedido_has_produto> getPedido_has_produto() {
		return pedido_has_produto;
	}

	public void setPedido_has_produto(Set<Pedido_has_produto> pedido_has_produto) {
		this.pedido_has_produto = pedido_has_produto;
	}
	
}
