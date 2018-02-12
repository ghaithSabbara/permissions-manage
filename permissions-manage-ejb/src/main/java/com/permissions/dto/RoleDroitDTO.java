package com.permissions.dto;

import java.util.Date;

public class RoleDroitDTO {
	String roleA;
	String roleB;
	String roleC;
	String roleD;
	String droit;
	Date date;

	public RoleDroitDTO(String droit, String roleA, String roleB, String roleC, String roleD, Date date) {
		super();
		this.droit = droit;
		this.roleA = roleA;
		this.roleB = roleB;
		this.roleC = roleC;
		this.roleD = roleD;
		this.date = date;
	}

	public RoleDroitDTO() {
		super();
	}

	public String getRoleA() {
		return roleA;
	}

	public void setRoleA(String roleA) {
		this.roleA = roleA;
	}

	public String getRoleB() {
		return roleB;
	}

	public void setRoleB(String roleB) {
		this.roleB = roleB;
	}

	public String getRoleC() {
		return roleC;
	}

	public void setRoleC(String roleC) {
		this.roleC = roleC;
	}

	public String getRoleD() {
		return roleD;
	}

	public void setRoleD(String roleD) {
		this.roleD = roleD;
	}

	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
