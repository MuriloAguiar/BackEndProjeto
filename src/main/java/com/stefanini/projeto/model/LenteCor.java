package com.stefanini.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stefanini.projeto.enums.SituacaoEnum;

@Entity
public class LenteCor implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LenteCorPK id;

	@ManyToOne
	@JoinColumn(name = "LE_NU", referencedColumnName = "LE_NU", insertable = false, updatable = false)
	private Lente lente;

	@ManyToOne
	@JoinColumn(name = "CO_NU", referencedColumnName = "CO_NU", insertable = false, updatable = false)
	private Cor cor;

	@Column(name = "CC_SIT")
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;

	public LenteCor() {
		super();
	}

	public LenteCor(Lente lente, Cor cor, SituacaoEnum situacao) {
		super();
		this.id = new LenteCorPK(lente.getId(), cor.getId());
		this.lente = lente;
		this.cor = cor;
		this.situacao = situacao;
	}

	public LenteCorPK getId() {
		return id;
	}

	public void setId(LenteCorPK id) {
		this.id = id;
	}

	public Lente getLente() {
		return lente;
	}

	public void setLente(Lente lente) {
		this.lente = lente;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

}