package br.com.monster.portal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "parcela")
public class Parcela {
	
	@Id
	@GeneratedValue
	private Long id_parcela;
	
	@NotNull(message="{parc.preco.NotEmpty}")
	@Size(min=2, max=20, message = "{parc.preco.Size}")
	@Column(name = "parc_preco")			//Nome real dentro do banco
	private Float preco_parc;			//Nome do campo no sistema
	
	@NotNull(message="{parc.numero.NotEmpty}")
	@Size(min=1, max=4, message = "{parc.numero.Size}")
	@Column(name = "parc_numero")			//Nome real dentro do banco
	private Integer numero_parc;			//Nome do campo no sistema
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updated_at;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "status_parcela_status_parcela", insertable=true, updatable=true)
	private Status_parcela status_parcela;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id_pedido", insertable=true, updatable=true)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_parcela() {
		return id_parcela;
	}

	public void setId_parcela(Long id_parcela) {
		this.id_parcela = id_parcela;
	}

	public Float getPreco_parc() {
		return preco_parc;
	}

	public void setPreco_parc(Float preco_parc) {
		this.preco_parc = preco_parc;
	}

	public Integer getNumero_parc() {
		return numero_parc;
	}

	public void setNumero_parc(Integer numero_parc) {
		this.numero_parc = numero_parc;
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

	public Status_parcela getStatus_parcela() {
		return status_parcela;
	}

	public void setStatus_parcela(Status_parcela status_parcela) {
		this.status_parcela = status_parcela;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	
	
	
}
