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

@Entity
@Table(name = "campanha")
public class Campanha {
	
	@Id
	@GeneratedValue
	private Long id_campanha;
	
	@Column(name = "cam_enviado")			//Nome real dentro do banco
	private Boolean enviado_cam;			//Nome do campo no sistema
	
	@Column(name = "cam_aberto")			//Nome real dentro do banco
	private Boolean aberto_cam;			//Nome do campo no sistema
	
	@Column(name = "cam_clicado")			//Nome real dentro do banco
	private Boolean clicado_cam;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "mailing_id_mailing", insertable=true, updatable=true)
	private Mailing mailing;
	
	// UM Ramal tem MUITOS Funcionários	(1-N)
	@OneToMany(mappedBy="campanha", fetch=FetchType.EAGER)
	private Set<Mensagem> mensagem;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_campanha() {
		return id_campanha;
	}

	public void setId_campanha(Long id_campanha) {
		this.id_campanha = id_campanha;
	}

	public Boolean getEnviado_cam() {
		return enviado_cam;
	}

	public void setEnviado_cam(Boolean enviado_cam) {
		this.enviado_cam = enviado_cam;
	}

	public Boolean getAberto_cam() {
		return aberto_cam;
	}

	public void setAberto_cam(Boolean aberto_cam) {
		this.aberto_cam = aberto_cam;
	}

	public Boolean getClicado_cam() {
		return clicado_cam;
	}

	public void setClicado_cam(Boolean clicado_cam) {
		this.clicado_cam = clicado_cam;
	}

	public Mailing getMailing() {
		return mailing;
	}

	public void setMailing(Mailing mailing) {
		this.mailing = mailing;
	}

	public Set<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(Set<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
