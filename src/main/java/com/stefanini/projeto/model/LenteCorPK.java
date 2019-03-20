package com.stefanini.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LenteCorPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "LE_NU")
	private Long idLente;

	@Column(name = "CO_NU")
	private Long idCor;

	public LenteCorPK() {
		super();
	}

	public LenteCorPK(Long idLente, Long idCor) {
		super();
		this.idLente = idLente;
		this.idCor = idCor;
	}

	public Long getIdLente() {
		return idLente;
	}

	public void setIdLente(Long idLente) {
		this.idLente = idLente;
	}

	public Long getIdCor() {
		return idCor;
	}

	public void setIdCor(Long idCor) {
		this.idCor = idCor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLente == null) ? 0 : idLente.hashCode());
		result = prime * result + ((idCor == null) ? 0 : idCor.hashCode());
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
		LenteCorPK other = (LenteCorPK) obj;
		if (idLente == null) {
			if (other.idLente != null)
				return false;
		} else if (!idLente.equals(other.idLente))
			return false;
		if (idCor == null) {
			if (other.idCor != null)
				return false;
		} else if (!idCor.equals(other.idCor))
			return false;
		return true;
	}

}