package com.permissions.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.permissions.dto.RoleDTO;
import com.permissions.dto.RoleDroitDTOFull;
import com.permissions.services.role.ManageRoleLocal;

@ManagedBean
@RequestScoped
public class RoleBean {

	private List<RoleDroitDTOFull> matrix;

	@EJB
	ManageRoleLocal manageRoleLocal;

	public RoleBean() {
		super();
	}

	public List<RoleDroitDTOFull> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<RoleDroitDTOFull> matrix) {
		this.matrix = matrix;
	}

	@PostConstruct
	public void init() {
		matrix = manageRoleLocal.findALLRoleDroitDTOFull();
	}

	private Boolean assignOrUnassignDroitToRole(Integer idRole, Integer idDroit, Boolean checked) {
		return manageRoleLocal.assignOrUnassignDroitToRole(idRole, idDroit, checked);
	}

	public void addMessage(RoleDTO roleDTO) {
		Boolean checked = assignOrUnassignDroitToRole(roleDTO.getIdRole(), roleDTO.getIdDroit(), roleDTO.getChecked());
		String summary = checked ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

}
