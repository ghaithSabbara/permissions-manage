package com.permissions.dto;

public class RoleDroitDTOFull {

	RoleDTO roleA;
	RoleDTO roleB;
	RoleDTO roleC;
	RoleDTO roleD;
	String droit;

	public RoleDroitDTOFull() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDroitDTOFull(RoleDTO roleA, RoleDTO roleB, RoleDTO roleC, RoleDTO roleD, String droit) {
		super();
		this.roleA = roleA;
		this.roleB = roleB;
		this.roleC = roleC;
		this.roleD = roleD;
		this.droit = droit;
	}

	public RoleDTO getRoleA() {
		return roleA;
	}

	public void setRoleA(RoleDTO roleA) {
		this.roleA = roleA;
	}

	public RoleDTO getRoleB() {
		return roleB;
	}

	public void setRoleB(RoleDTO roleB) {
		this.roleB = roleB;
	}

	public RoleDTO getRoleC() {
		return roleC;
	}

	public void setRoleC(RoleDTO roleC) {
		this.roleC = roleC;
	}

	public RoleDTO getRoleD() {
		return roleD;
	}

	public void setRoleD(RoleDTO roleD) {
		this.roleD = roleD;
	}

	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}

}
