package br.com.monster.portal.model;

import java.util.List;
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

/*
 * @author Iuri Godoy
 * @version 2
 * @since Release 03 do 5º semestre
 */

@Entity
@Table(name = "produto")
public class Produto extends Historico {

	@Id
	@GeneratedValue
	private Long id_produto;

	@NotNull(message="{pro.nome.NotEmpty}")
	@Size(min=2, max=200, message = "{pro.nome.Size}")
	@Column(name = "pro_nome", unique=true)
	private String nome_pro;

	@NotNull(message="{pro.descricao.NotEmpty}")
	@Size(min=20, max=2000, message = "{pro.descricao.Size}")
	@Column(name = "pro_descricao")
	private String descricao_pro;


	@Column(name = "pro_publicado")
	private Boolean publicado_pro;

	@Column(name = "pro_destaque")
	private Boolean destaque_pro;

	@Column(name = "pro_promocao")
	private Boolean promocao_pro;

	@Column(name = "pro_desconto")
	private Double desconto_pro = 0.00;		//  1.00 = 100%
	

	@NotNull(message="{pro.peso.NotEmpty}")
	@Column(name = "pro_peso")
	private Double peso_pro = 0.000;		// Padrão em quilogramas (kg)

	@NotNull(message="{pro.altura.NotEmpty}")
	@Column(name = "pro_altura")
	private Double altura_pro = 0.000;		// Padrão em centímetros (cm)

	@NotNull(message="{pro.largura.NotEmpty}")
	@Column(name = "pro_largura")
	private Double largura_pro = 0.000;		// Padrão em centímetros (cm)

	@NotNull(message="{pro.comprimento.NotEmpty}")
	@Column(name = "pro_comprimento")
	private Double comprimento_pro = 0.000;	// Padrão em centímetros (cm)

	@NotNull(message="{pro.diametro.NotEmpty}")
	@Column(name = "pro_diametro")
	private Double diametro_pro = 0.000;	// Padrão em centímetros (cm)

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	// MUITOS Ramais est�o em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "categoria_id_categoria", insertable=true, updatable=true)
	private Categoria categoria;
	
	

	@OneToMany(mappedBy="produto", fetch=FetchType.EAGER)
	private Set<Produto_has_fornecedor> produto_has_fornecedor;

	@OneToMany(mappedBy="produto", fetch=FetchType.EAGER)
	private List<Imagem> imagem;

	@OneToMany(mappedBy="produto")
	private Set<Banner> banner;

	@OneToMany(mappedBy="produto")
	private Set<Pedido_has_produto> pedido_has_produto;
	
	// Outros M�todos
	
	public Double calcularDesconto(Double precoProduto){
		if(promocao_pro){
			Double desconto = precoProduto * desconto_pro;
			Double precoDescontado = precoProduto - desconto;
			return precoDescontado;
		} else {
			return precoProduto;
		}
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

	public Boolean getPromocao_pro() {
		return promocao_pro;
	}

	public void setPromocao_pro(Boolean promocao_pro) {
		this.promocao_pro = promocao_pro;
	}

	public Double getDesconto_pro() {
		return desconto_pro;
	}

	public void setDesconto_pro(Double desconto_pro) {
		this.desconto_pro = desconto_pro;
	}

	public Double getPeso_pro() {
		return peso_pro;
	}

	public void setPeso_pro(Double peso_pro) {
		this.peso_pro = peso_pro;
	}

	public Double getAltura_pro() {
		return altura_pro;
	}

	public void setAltura_pro(Double altura_pro) {
		this.altura_pro = altura_pro;
	}

	public Double getLargura_pro() {
		return largura_pro;
	}

	public void setLargura_pro(Double largura_pro) {
		this.largura_pro = largura_pro;
	}

	public Double getComprimento_pro() {
		return comprimento_pro;
	}

	public void setComprimento_pro(Double comprimento_pro) {
		this.comprimento_pro = comprimento_pro;
	}

	public Double getDiametro_pro() {
		return diametro_pro;
	}

	public void setDiametro_pro(Double diametro_pro) {
		this.diametro_pro = diametro_pro;
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

	public List<Imagem> getImagem() {
		return imagem;
	}

	public void setImagem(List<Imagem> imagem) {
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

}









