package com.permissions.dto;

public class RoleDTO {

	Boolean checked;
	Integer idRole;
	Integer idDroit;

	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDTO(Boolean checked, Integer idRole, Integer idDroit) {
		super();
		this.checked = checked;
		this.idRole = idRole;
		this.idDroit = idDroit;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Integer getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(Integer idDroit) {
		this.idDroit = idDroit;
	}

}
