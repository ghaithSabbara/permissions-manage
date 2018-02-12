package com.permissions.services.role;

import java.util.List;
import javax.ejb.Remote;
import com.permissions.dto.RoleDroitDTOFull;

@Remote
public interface ManageRoleRemote {
	List<RoleDroitDTOFull> findALLRoleDroitDTOFull();

	Boolean assignOrUnassignDroitToRole(Integer idRole, Integer idDroit, Boolean checked);
}
