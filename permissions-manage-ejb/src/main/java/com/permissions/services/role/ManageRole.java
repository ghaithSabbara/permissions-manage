package com.permissions.services.role;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import com.permissions.domain.Droit;
import com.permissions.domain.Role;
import com.permissions.domain.RoleDroit;
import com.permissions.dto.RoleDTO;
import com.permissions.dto.RoleDroitDTO;
import com.permissions.dto.RoleDroitDTOFull;

/**
 * Session Bean implementation class ManageRole
 */
@Stateless
@LocalBean
public class ManageRole implements ManageRoleRemote, ManageRoleLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ManageRole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RoleDroitDTOFull> findALLRoleDroitDTOFull() {

		return getRoleDroitDTOFullList();
	}

	@Override
	public Boolean assignOrUnassignDroitToRole(Integer idRole, Integer idDroit, Boolean checked) {
		if (checked.equals(true)) {
			return assignDroitToRole(idRole, idDroit);
		} else {
			return unassignDroitToRole(idRole, idDroit);
		}
	}

	private List<RoleDroitDTO> findAllRoleDroit() {

		@SuppressWarnings("unchecked")
		List<RoleDroitDTO> results = entityManager
				.createQuery("SELECT  d.name as droit"
						+ ", (  d.id || ',1,' || CASE WHEN (EXISTS (SELECT rd FROM RoleDroit rd WHERE rd.droit.id = d.id AND rd.role.id = 1)) then true else false end) AS roleA "
						+ ", (  d.id || ',2,' || CASE WHEN (EXISTS (SELECT rd FROM RoleDroit rd WHERE rd.droit.id = d.id AND rd.role.id = 2)) then true else false end) AS roleB "
						+ ", (  d.id || ',3,' || CASE WHEN (EXISTS (SELECT rd FROM RoleDroit rd WHERE rd.droit.id = d.id AND rd.role.id = 3)) then true else false end) AS roleC "
						+ ", (  d.id || ',4,' || CASE WHEN (EXISTS (SELECT rd FROM RoleDroit rd WHERE rd.droit.id = d.id AND rd.role.id = 4)) then true else false end) AS roleD "
						+ "FROM   Droit d ORDER  BY d.id ")
				.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.aliasToBean(RoleDroitDTO.class))
				.list();

		return results;
	}

	private RoleDTO toRoleDTO(String role) {

		String[] splitted = role.split(",");
		boolean checked = Boolean.parseBoolean(splitted[2]);
		Integer idRole = Integer.parseInt(splitted[1]);
		Integer idDroit = Integer.parseInt(splitted[0]);
		RoleDTO roleDTO = new RoleDTO(checked, idRole, idDroit);

		return roleDTO;
	}

	private RoleDroitDTOFull toRoleDroitDTOFull(String roleA, String roleB, String roleC, String roleD, String droit) {

		RoleDroitDTOFull roleDroitDTOFull = new RoleDroitDTOFull(toRoleDTO(roleA), toRoleDTO(roleB), toRoleDTO(roleC),
				toRoleDTO(roleD), droit);

		return roleDroitDTOFull;
	}

	private List<RoleDroitDTOFull> getRoleDroitDTOFullList() {

		List<RoleDroitDTO> roleDroitDTOList = findAllRoleDroit();

		List<RoleDroitDTOFull> roleDroitDTOFullList = roleDroitDTOList.stream().map(roleDroitDTO -> {

			RoleDroitDTOFull roleDroitDTOFull = toRoleDroitDTOFull(roleDroitDTO.getRoleA(), roleDroitDTO.getRoleB(),
					roleDroitDTO.getRoleC(), roleDroitDTO.getRoleD(), roleDroitDTO.getDroit());
			return roleDroitDTOFull;
		}).collect(Collectors.toList());

		return roleDroitDTOFullList;
	}

	private RoleDroit findRoleDroitByIdRoleAndIdDroit(Integer idRole, Integer idDroit) {
		Query query = entityManager
				.createQuery("SELECT rd FROM RoleDroit rd WHERE rd.role.id =:idRole AND rd.droit.id =:idDroit");
		query.setParameter("idRole", idRole);
		query.setParameter("idDroit", idDroit);
		// List<RoleDroit> roleDroits = query.getResultList();
		try {
			RoleDroit roleDroit = (RoleDroit) query.getSingleResult();
			return roleDroit;
		} catch (NoResultException nre) {
			return null;
		}

		// return roleDroits.get(0);
	}

	private void deleteRoleDroit(RoleDroit roleDroit) {
		entityManager.remove(entityManager.merge(roleDroit));
	}

	private Boolean assignDroitToRole(Integer idRole, Integer idDroit) {
		Role role = entityManager.find(Role.class, idRole);
		Droit droit = entityManager.find(Droit.class, idDroit);
		RoleDroit roleDroit = new RoleDroit(role, droit);
		entityManager.persist(roleDroit);
		return true;
	}

	private Boolean unassignDroitToRole(Integer idRole, Integer idDroit) {
		RoleDroit roleDroit = findRoleDroitByIdRoleAndIdDroit(idRole, idDroit);
		if (Objects.nonNull(roleDroit)) {
			deleteRoleDroit(roleDroit);
		}
		return false;
	}

}
