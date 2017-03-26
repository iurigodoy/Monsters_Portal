package br.com.monster.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mensagem")
public class Mensagem {

	@Id
	@GeneratedValue
	private Long id_mensagem;
	
	@NotNull(message="{msg.descricao.NotEmpty}")
	@Size(min=15, max=600, message = "{msg.descricao.Size}")
	@Column(name = "msg_descricao")			//Nome real dentro do banco
	private String descricao_msg;			//Nome do campo no sistema
	
	@NotNull(message="{msg.titulo.NotEmpty}")
	@Size(min=2, max=100, message = "{msg.titulo.Size}")
	@Column(name = "msg_titulo")			//Nome real dentro do banco
	private String titulo_msg;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "campanha_id_campanha", insertable=true, updatable=true)
	private Campanha campanha;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_mensagem() {
		return id_mensagem;
	}

	public void setId_mensagem(Long id_mensagem) {
		this.id_mensagem = id_mensagem;
	}

	public String getDescricao_msg() {
		return descricao_msg;
	}

	public void setDescricao_msg(String descricao_msg) {
		this.descricao_msg = descricao_msg;
	}

	public String getTitulo_msg() {
		return titulo_msg;
	}

	public void setTitulo_msg(String titulo_msg) {
		this.titulo_msg = titulo_msg;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	
	
}
