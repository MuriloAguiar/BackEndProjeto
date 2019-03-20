package com.stefanini.projeto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.stefanini.projeto.enums.SituacaoEnum;

@Entity
public class Oculos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_OC_NU", sequenceName = "SQ_OC_NU", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OC_NU")
	@Column(name = "OC_NU")
	private Long id;

	@Column(name = "OC_NO", length = 20)
	private String nome;

	@Column(name = "OC_SIT")
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;

	@OneToMany(mappedBy = "oculos",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Lente> lentes = new ArrayList<>();

	public Oculos() {
		super();
	}

	public Oculos(Long id, String nome, SituacaoEnum situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	
	public List<Lente> getLentes() {
		return lentes;
	}
	
	public void setLente(Lente lente) {
		this.lentes.add(lente);
	}

	public void setLentes(List<Lente> lentes) {
		this.lentes = lentes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oculos other = (Oculos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}