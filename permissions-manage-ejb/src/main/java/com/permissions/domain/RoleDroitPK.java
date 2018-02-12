package com.permissions.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RoleDroitPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idRole;
	private Integer idDroit;
	private Date dateAffectation;
	
	public RoleDroitPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Column(name = "id_role")
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	@Column(name = "id_droit")
	public Integer getIdDroit() {
		return idDroit;
	}
	public void setIdDroit(Integer idDroit) {
		this.idDroit = idDroit;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_affectation")
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAffectation == null) ? 0 : dateAffectation.hashCode());
		result = prime * result + ((idDroit == null) ? 0 : idDroit.hashCode());
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
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
		RoleDroitPK other = (RoleDroitPK) obj;
		if (dateAffectation == null) {
			if (other.dateAffectation != null)
				return false;
		} else if (!dateAffectation.equals(other.dateAffectation))
			return false;
		if (idDroit == null) {
			if (other.idDroit != null)
				return false;
		} else if (!idDroit.equals(other.idDroit))
			return false;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		return true;
	}

	public RoleDroitPK(Integer idRole, Integer idDroit, Date dateAffectation) {
		super();
		this.idRole = idRole;
		this.idDroit = idDroit;
		this.dateAffectation = dateAffectation;
	}
	
	
}
