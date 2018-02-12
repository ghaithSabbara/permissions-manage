package com.permissions.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role_Droit
 *
 */
@Entity
@Table(name = "role_droit")

public class RoleDroit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Role role;
	private Droit droit;
	private RoleDroitPK roleDroitPK;

	public RoleDroit() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "id_role", referencedColumnName = "id", insertable = false, updatable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name = "id_droit", referencedColumnName = "id", insertable = false, updatable = false)
	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	@EmbeddedId
	public RoleDroitPK getRoleDroitPK() {
		return roleDroitPK;
	}

	public void setRoleDroitPK(RoleDroitPK roleDroitPK) {
		this.roleDroitPK = roleDroitPK;
	}

	public RoleDroit(Role role, Droit droit) {
		super();
		this.role = role;
		this.droit = droit;
		this.roleDroitPK = new RoleDroitPK(role.getId(), droit.getId(), new Date());
	}

}
