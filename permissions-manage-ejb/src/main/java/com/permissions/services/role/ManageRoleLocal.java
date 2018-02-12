package com.permissions.services.role;

import java.util.List;
import javax.ejb.Local;
import com.permissions.dto.RoleDroitDTOFull;

@Local
public interface ManageRoleLocal {

	List<RoleDroitDTOFull> findALLRoleDroitDTOFull();

	Boolean assignOrUnassignDroitToRole(Integer idRole, Integer idDroit, Boolean checked);
}
