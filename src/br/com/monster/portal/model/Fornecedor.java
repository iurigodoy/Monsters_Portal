package br.com.monster.portal.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue
	private Long id_fornecedor;
	
	@NotNull(message="{for.nome.NotEmpty}")
	@Size(min=1, max=200, message = "{for.nome.Size}")
	@Column(name = "for_nome")				//Nome real dentro do banco
	private String nome_for;				//Nome do campo no sistema
	
	@NotNull(message="{for.cnpj.NotEmpty}")
	@Size(min=2, max=20, message = "{for.cnpj.Size}")
	@Column(name = "for_cnpj")				//Nome real dentro do banco
	private String cnpj_for;				//Nome do campo no sistema
	
	@NotNull(message="{for.logo.NotEmpty}")
	@Size(min=2, max=100, message = "{for.logo.Size}")
	@Column(name = "for_logo", unique=true)	//Nome real dentro do banco
	private String logo_for;				//Nome do campo no sistema
	
	@NotNull(message="{for.cep.NotEmpty}")
	@Size(min=7, max=20, message = "{for.cep.Size}")
	@Column(name = "for_cep")				//Nome real dentro do banco
	private String cep_for;					//Nome do campo no sistema
	
	@NotNull(message="{for.estado.NotEmpty}")
	@Size(min=2, max=10, message = "{for.estado.Size}")
	@Column(name = "for_estado")			//Nome real dentro do banco
	private String estado_for;				//Nome do campo no sistema
	
	@NotNull(message="{for.cidade.NotEmpty}")
	@Size(min=3, max=50, message = "{for.cidade.Size}")
	@Column(name = "for_cidade")			//Nome real dentro do banco
	private String cidade_for;				//Nome do campo no sistema
	
	@NotNull(message="{for.endereco.NotEmpty}")
	@Size(min=6, max=50, message = "{for.endereco.Size}")
	@Column(name = "for_endereco")			//Nome real dentro do banco
	private String endereco_for;			//Nome do campo no sistema
	
	@Column(name = "for_numero")			//Nome real dentro do banco
	private String numero_for;				//Nome do campo no sistema
	
	@Column(name = "for_complemento")		//Nome real dentro do banco
	private String complemento_for;			//Nome do campo no sistema
	
	@NotNull(message="{for.email.NotEmpty}")
	@Size(min=10, max=255, message = "{for.email.Size}")
	@Column(name = "for_email", unique=true)//Nome real dentro do banco
	private String email_for;				//Nome do campo no sistema
	
	@NotNull(message="{for.comercial.NotEmpty}")
	@Size(min=3, max=20, message = "{for.comercial.Size}")
	@Column(name = "for_comercial")			//Nome real dentro do banco
	private String comercial_for;			//Nome do campo no sistema
	
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
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="fornecedor")
	private Set<Produto_has_fornecedor> produto_has_fornecedor;

	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Long id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNome_for() {
		return nome_for;
	}

	public void setNome_for(String nome_for) {
		this.nome_for = nome_for;
	}

	public String getCnpj_for() {
		return cnpj_for;
	}

	public void setCnpj_for(String cnpj_for) {
		this.cnpj_for = cnpj_for;
	}

	public String getLogo_for() {
		return logo_for;
	}

	public void setLogo_for(String logo_for) {
		this.logo_for = logo_for;
	}

	public String getCep_for() {
		return cep_for;
	}

	public void setCep_for(String cep_for) {
		this.cep_for = cep_for;
	}

	public String getEstado_for() {
		return estado_for;
	}

	public void setEstado_for(String estado_for) {
		this.estado_for = estado_for;
	}

	public String getCidade_for() {
		return cidade_for;
	}

	public void setCidade_for(String cidade_for) {
		this.cidade_for = cidade_for;
	}

	public String getEndereco_for() {
		return endereco_for;
	}

	public void setEndereco_for(String endereco_for) {
		this.endereco_for = endereco_for;
	}

	public String getComplemento_for() {
		return complemento_for;
	}

	public void setComplemento_for(String complemento_for) {
		this.complemento_for = complemento_for;
	}

	public String getEmail_for() {
		return email_for;
	}

	public void setEmail_for(String email_for) {
		this.email_for = email_for;
	}

	public String getComercial_for() {
		return comercial_for;
	}

	public void setComercial_for(String comercial_for) {
		this.comercial_for = comercial_for;
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

	public Set<Produto_has_fornecedor> getProduto_has_fornecedor() {
		return produto_has_fornecedor;
	}

	public void setProduto_has_fornecedor(
			Set<Produto_has_fornecedor> produto_has_fornecedor) {
		this.produto_has_fornecedor = produto_has_fornecedor;
	}
	
	
}
