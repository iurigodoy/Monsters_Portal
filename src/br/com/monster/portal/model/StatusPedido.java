package br.com.monster.portal.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "statusPedido")
public class StatusPedido {
	
	@Id
	@GeneratedValue
	private Long id_status_pedido;
	
	private String status;
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Status está em MUITOS Pedidos	(1-N)
	@OneToMany(mappedBy="statusPedido", fetch=FetchType.EAGER)
	private Set<Pedido> pedido;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_status_pedido() {
		return id_status_pedido;
	}

	public String getStatus() {
		return status;
	}

	public Set<Pedido> getPedido() {
		return pedido;
	}
	
	
}
