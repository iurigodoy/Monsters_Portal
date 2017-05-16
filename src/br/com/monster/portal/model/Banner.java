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
@Table(name = "banner")
public class Banner {
	
	@Id
	@GeneratedValue
	private Long id_banner;
	
	@NotNull(message="{ban.arquivo.NotEmpty}")
	@Size(min=2, max=100, message = "{ban.arquivo.Size}")
	@Column(name = "ban_arquivo", unique=true)	//Nome real dentro do banco
	private String arquivo_ban;			//Nome do campo no sistema
	
	@Column(name = "ban_ativo")			//Nome real dentro do banco
	private Boolean ativo_ban;			//Nome do campo no sistema
	
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

	// MUITOS Ramais est�o em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_banner() {
		return id_banner;
	}

	public void setId_banner(Long id_banner) {
		this.id_banner = id_banner;
	}

	public String getArquivo_ban() {
		return arquivo_ban;
	}

	public void setArquivo_ban(String arquivo_ban) {
		this.arquivo_ban = arquivo_ban;
	}

	public Boolean getAtivo_ban() {
		return ativo_ban;
	}

	public void setAtivo_ban(Boolean ativo_ban) {
		this.ativo_ban = ativo_ban;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
