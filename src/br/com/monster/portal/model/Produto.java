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
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue
	private Long id_produto;

	@NotNull(message="{pro.nome.NotEmpty}")
	@Size(min=2, max=200, message = "{pro.nome.Size}")
	@Column(name = "pro_nome")			//Nome real dentro do banco
	private String nome_pro;			//Nome do campo no sistema

	@NotNull(message="{pro.descricao.NotEmpty}")
	@Size(min=20, max=2000, message = "{pro.descricao.Size}")
	@Column(name = "pro_descricao")			//Nome real dentro do banco
	private String descricao_pro;			//Nome do campo no sistema


	@Column(name = "pro_publicado")			//Nome real dentro do banco
	private Boolean publicado_pro;			//Nome do campo no sistema

	@Column(name = "pro_destaque")			//Nome real dentro do banco
	private Boolean destaque_pro;			//Nome do campo no sistema


	@Column(name = "pro_desconto")			//Nome real dentro do banco
	private Integer desconto_pro;			//Nome do campo no sistema

	@Column(name = "pro_promocao")			//Nome real dentro do banco
	private Boolean promocao_pro;			//Nome do campo no sistema

	@NotNull(message="{pro.peso.NotEmpty}")
	@Size(min=2, max=12, message = "{pro.peso.Size}")
	@Column(name = "pro_peso")			//Nome real dentro do banco
	private String peso_pro;			//Nome do campo no sistema

	@NotNull(message="{pro.altura.NotEmpty}")
	@Size(min=2, max=10, message = "{pro.altura.Size}")
	@Column(name = "pro_altura")			//Nome real dentro do banco
	private String altura_pro;			//Nome do campo no sistema

	@NotNull(message="{pro.largura.NotEmpty}")
	@Size(min=2, max=10, message = "{pro.largura.Size}")
	@Column(name = "pro_largura")			//Nome real dentro do banco
	private String largura_pro;			//Nome do campo no sistema

	@NotNull(message="{pro.comprimento.NotEmpty}")
	@Size(min=2, max=10, message = "{pro.comprimento.Size}")
	@Column(name = "pro_comprimento")			//Nome real dentro do banco
	private String comprimento_pro;			//Nome do campo no sistema
	
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

	// MUITOS Ramais estï¿½o em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "categoria_id_categoria", insertable=true, updatable=true)
	private Categoria categoria;
	
	

	@OneToMany(mappedBy="produto", fetch=FetchType.EAGER)
	private Set<Produto_has_fornecedor> produto_has_fornecedor;

	@OneToMany(mappedBy="produto", fetch=FetchType.EAGER)
	private Set<Imagem> imagem;

	@OneToMany(mappedBy="produto", fetch=FetchType.EAGER)
	private Set<Banner> banner;

	@OneToMany(mappedBy="produto", fetch=FetchType.EAGER)
	private Set<Pedido_has_produto> pedido_has_produto;
	
	// Outros Métodos
	
	public float calcularDesconto(float precoProduto){
		float desconto = precoProduto * (desconto_pro / 100);
		float precoDescontado = precoProduto - desconto;
		return precoDescontado;
	}
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)		
	|---------------------------------------
	*/

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_pro() {
		return nome_pro;
	}

	public void setNome_pro(String nome_pro) {
		this.nome_pro = nome_pro;
	}

	public String getDescricao_pro() {
		return descricao_pro;
	}

	public void setDescricao_pro(String descricao_pro) {
		this.descricao_pro = descricao_pro;
	}

	public Boolean getPublicado_pro() {
		return publicado_pro;
	}

	public void setPublicado_pro(Boolean publicado_pro) {
		this.publicado_pro = publicado_pro;
	}

	public Boolean getDestaque_pro() {
		return destaque_pro;
	}

	public void setDestaque_pro(Boolean destaque_pro) {
		this.destaque_pro = destaque_pro;
	}

	public Integer getDesconto_pro() {
		return desconto_pro;
	}

	public void setDesconto_pro(Integer desconto_pro) {
		this.desconto_pro = desconto_pro;
	}

	public Boolean getPromocao_pro() {
		return promocao_pro;
	}

	public void setPromocao_pro(Boolean promocao_pro) {
		this.promocao_pro = promocao_pro;
	}

	public String getPeso_pro() {
		return peso_pro;
	}

	public void setPeso_pro(String peso_pro) {
		this.peso_pro = peso_pro;
	}

	public String getAltura_pro() {
		return altura_pro;
	}

	public void setAltura_pro(String altura_pro) {
		this.altura_pro = altura_pro;
	}

	public String getLargura_pro() {
		return largura_pro;
	}

	public void setLargura_pro(String largura_pro) {
		this.largura_pro = largura_pro;
	}

	public String getComprimento_pro() {
		return comprimento_pro;
	}

	public void setComprimento_pro(String comprimento_pro) {
		this.comprimento_pro = comprimento_pro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Produto_has_fornecedor> getProduto_has_fornecedor() {
		return produto_has_fornecedor;
	}

	public void setProduto_has_fornecedor(Set<Produto_has_fornecedor> produto_has_fornecedor) {
		this.produto_has_fornecedor = produto_has_fornecedor;
	}

	public Set<Imagem> getImagem() {
		return imagem;
	}

	public void setImagem(Set<Imagem> imagem) {
		this.imagem = imagem;
	}

	public Set<Banner> getBanner() {
		return banner;
	}

	public void setBanner(Set<Banner> banner) {
		this.banner = banner;
	}

	public Set<Pedido_has_produto> getPedido_has_produto() {
		return pedido_has_produto;
	}

	public void setPedido_has_produto(Set<Pedido_has_produto> pedido_has_produto) {
		this.pedido_has_produto = pedido_has_produto;
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

}









