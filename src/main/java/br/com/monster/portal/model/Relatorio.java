package br.com.monster.portal.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;

@Entity
@Table(name = "relatorio")
public class Relatorio {

	@Id
	@GeneratedValue
	private Long id_relatorio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	private EnumEntidade entidade;

	private EnumMetodo metodo;
	
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

	public Calendar getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Calendar calendar) {
		this.created_at = calendar;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public EnumEntidade getEntidade() {
		return entidade;
	}

	public void setEntidade(EnumEntidade entidade) {
		this.entidade = entidade;
	}

	public EnumMetodo getMetodo() {
		return metodo;
	}

	public void setMetodo(EnumMetodo metodo) {
		this.metodo = metodo;
	}
	
	
}
