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
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue
	private Long id_funcionario;
	
	@NotNull(message="{fun.nome.NotEmpty}")
	@Size(min=3, max=200, message = "{fun.nome.Size}")
	@Column(name = "fun_nome")			//Nome real dentro do banco
	private String nome_fun;			//Nome do campo no sistema
	
	@NotNull(message="{fun.cpf.NotEmpty}")
	@Column(name = "fun_cpf", unique = true)			//Nome real dentro do banco
	private String cpf_fun;			//Nome do campo no sistema
	
	
	@Column(name = "fun_bloqueado")			//Nome real dentro do banco
	private Boolean bloqueado_fun;			//Nome do campo no sistema
	
	@NotNull(message="{fun.foto.NotEmpty}")
	@Size(min=1, max=100, message = "{fun.foto.Size}")
	@Column(name = "fun_foto", unique = true)			//Nome real dentro do banco
	private String foto_fun;			//Nome do campo no sistema
	

	@Column(name = "fun_residencial")			//Nome real dentro do banco
	private String residencial_fun;			//Nome do campo no sistema
	
	@NotNull(message="{fun.celular.NotEmpty}")
	@Size(min=8, max=20, message = "{fun.celular.Size}")
	@Column(name = "fun_celular")			//Nome real dentro do banco
	private String celular_fun;			//Nome do campo no sistema
	
	@NotNull(message="{fun.email.NotEmpty}")
	@Size(min=10, max=255, message = "{fun.email.Size}")
	@Column(name = "fun_email", unique = true)			//Nome real dentro do banco
	private String email_fun;			//Nome do campo no sistema
	
	@NotNull(message="{fun.senha.NotEmpty}")
	@Size(min=6, max=255, message = "{fun.senha.Size}")
	@Column(name = "fun_senha")			//Nome real dentro do banco
	private String senha_fun;			//Nome do campo no sistema
	
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
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "cargo_id_cargo", insertable=true, updatable=true)
	private Cargo cargo;
	
	// UM Ramal tem MUITOS Funcionários	(1-N)
	@OneToMany(mappedBy="funcionario", fetch=FetchType.EAGER)
	private Set<Relatorios> relatorios;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome_fun() {
		return nome_fun;
	}

	public void setNome_fun(String nome_fun) {
		this.nome_fun = nome_fun;
	}

	public String getCpf_fun() {
		return cpf_fun;
	}

	public void setCpf_fun(String cpf_fun) {
		this.cpf_fun = cpf_fun;
	}

	public Boolean getBloqueado_fun() {
		return bloqueado_fun;
	}

	public void setBloqueado_fun(Boolean bloqueado_fun) {
		this.bloqueado_fun = bloqueado_fun;
	}

	public String getFoto_fun() {
		return foto_fun;
	}

	public void setFoto_fun(String foto_fun) {
		this.foto_fun = foto_fun;
	}

	public String getResidencial_fun() {
		return residencial_fun;
	}

	public void setResidencial_fun(String residencial_fun) {
		this.residencial_fun = residencial_fun;
	}

	public String getCelular_fun() {
		return celular_fun;
	}

	public void setCelular_fun(String celular_fun) {
		this.celular_fun = celular_fun;
	}

	public String getEmail_fun() {
		return email_fun;
	}

	public void setEmail_fun(String email_fun) {
		this.email_fun = email_fun;
	}

	public String getSenha_fun() {
		return senha_fun;
	}

	public void setSenha_fun(String senha_fun) {
		this.senha_fun = senha_fun;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Set<Relatorios> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(Set<Relatorios> relatorios) {
		this.relatorios = relatorios;
	}
	
	
}
