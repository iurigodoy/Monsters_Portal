package br.com.monster.portal.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "forma_pagamento")
public class Forma_pagamento {
	
	@Id
	@GeneratedValue
	private Long id_forma_pagamento;
	
	@Column(name = "nome_forma_pagamento")			//Nome real dentro do banco
	private String forma_pagamento_nome;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcionários	(1-N)
	@OneToMany(mappedBy="forma_pagamento", fetch=FetchType.EAGER)
	private Set<Pedido> pedido;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_forma_pagamento() {
		return id_forma_pagamento;
	}

	public void setId_forma_pagamento(Long id_forma_pagamento) {
		this.id_forma_pagamento = id_forma_pagamento;
	}

	public String getForma_pagamento_nome() {
		return forma_pagamento_nome;
	}

	public void setForma_pagamento_nome(String forma_pagamento_nome) {
		this.forma_pagamento_nome = forma_pagamento_nome;
	}

	public Set<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	
	
}
