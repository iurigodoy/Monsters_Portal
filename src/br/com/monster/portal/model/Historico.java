package br.com.monster.portal.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Historico {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Calendar updated_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_at")
	private Calendar deleted_at;
	
	@Column(name = "deleted")
	private Boolean deleted;
	
	public void criarHistorico() {
		Calendar data = Calendar.getInstance();
		created_at = data;
		updated_at = data;
		deleted = false;
	}
	
	public void atualizarHistorico(){Calendar data = Calendar.getInstance();
		updated_at = data;
	}
	
	public Date getDateTime() {
		Calendar data = Calendar.getInstance();
		Date datetime = data.getTime();
		return datetime;
	}

	public Calendar getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Calendar created_at) {
		this.created_at = created_at;
	}

	public Calendar getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Calendar updated_at) {
		this.updated_at = updated_at;
	}

	public Calendar getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Calendar deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
