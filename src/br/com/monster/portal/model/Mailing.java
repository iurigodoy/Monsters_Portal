package br.com.monster.portal.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mailing")
public class Mailing {

	@Id
	@GeneratedValue
	private Long id_mailing;
	
	@NotNull(message="{mai.email.NotEmpty}")
	@Size(min=10, max=50, message = "{mai.email.Size}")
	@Column(name = "mai_email")			//Nome real dentro do banco
	private String email_mai;			//Nome do campo no sistema
	
	@NotNull(message="{mai.nome.NotEmpty}")
	@Size(min=3, max=50, message = "{mai.nome.Size}")
	@Column(name = "mai_nome")			//Nome real dentro do banco
	private String nome_mai;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	// UM Ramal tem MUITOS Funcionários	(1-N)
	@OneToMany(mappedBy="mailing", fetch=FetchType.EAGER)
	private Set<Campanha> campanha;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_mailing() {
		return id_mailing;
	}

	public void setId_mailing(Long id_mailing) {
		this.id_mailing = id_mailing;
	}

	public String getEmail_mai() {
		return email_mai;
	}

	public void setEmail_mai(String email_mai) {
		this.email_mai = email_mai;
	}

	public String getNome_mai() {
		return nome_mai;
	}

	public void setNome_mai(String nome_mai) {
		this.nome_mai = nome_mai;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Campanha> getCampanha() {
		return campanha;
	}

	public void setCampanha(Set<Campanha> campanha) {
		this.campanha = campanha;
	}
	
	
}
