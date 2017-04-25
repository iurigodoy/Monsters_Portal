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

@Entity
@Table(name = "relatorio")
public class Relatorio {

	@Id
	@GeneratedValue
	private Long id_relatorio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "entidade_id_entidade", insertable=true, updatable=true)
	private Entidade entidade;
	
	@ManyToOne
	@JoinColumn(name = "metodo_id_metodo", insertable=true, updatable=true)
	private Metodo metodo;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id_funcionario", insertable=true, updatable=true)
	private Funcionario funcionario;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_relatorio() {
		return id_relatorio;
	}

	public void setId_relatorio(Long id_relatorios) {
		this.id_relatorio = id_relatorios;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Metodo getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
