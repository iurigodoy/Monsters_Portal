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
@Table(name = "status_parcela")
public class Status_parcela {
	
	@Id
	@GeneratedValue
	private Long status_parcela;
	
	@Column(name = "sta_nome")			//Nome real dentro do banco
	private String nome_sta;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcionários	(1-N)
	@OneToMany(mappedBy="status_parcela", fetch=FetchType.EAGER)
	private Set<Parcela> parcela;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getStatus_parcela() {
		return status_parcela;
	}

	public void setStatus_parcela(Long status_parcela) {
		this.status_parcela = status_parcela;
	}

	public String getNome_sta() {
		return nome_sta;
	}

	public void setNome_sta(String nome_sta) {
		this.nome_sta = nome_sta;
	}

	public Set<Parcela> getParcela() {
		return parcela;
	}

	public void setParcela(Set<Parcela> parcela) {
		this.parcela = parcela;
	}
	
	
}
