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
@Table(name = "avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue
	private Long id_avaliacao;
	
	@Column(name = "ava_comentario")			//Nome real dentro do banco
	private String comentario_ava;			//Nome do campo no sistema
	
	@NotNull(message="{ava.nota.NotEmpty}")
	@Size(min=1, max=10, message = "{ava.nota.Size}")
	@Column(name = "ava_nota")			//Nome real dentro do banco
	private Integer nota_ava;			//Nome do campo no sistema
	
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
		@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
		private Cliente cliente;
			
		@ManyToOne
		@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
		private Produto produto;
		
		/*
		|---------------------------------------
		|		Getters And Setters(GGAS)				
		|---------------------------------------
		*/

		
		public Long getId_avaliacao() {
			return id_avaliacao;
		}

		public void setId_avaliacao(Long id_avaliacao) {
			this.id_avaliacao = id_avaliacao;
		}

		public String getComentario_ava() {
			return comentario_ava;
		}

		public void setComentario_ava(String comentario_ava) {
			this.comentario_ava = comentario_ava;
		}

		public Integer getNota_ava() {
			return nota_ava;
		}

		public void setNota_ava(Integer nota_ava) {
			this.nota_ava = nota_ava;
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

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

}
