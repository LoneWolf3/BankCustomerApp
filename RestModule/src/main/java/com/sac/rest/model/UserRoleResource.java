package com.sac.rest.model;

import com.sac.model.AppUserRole;
import com.sac.model.UserRole;

public class UserRoleResource extends DefaultResource implements AppUserRole{

	private UserRole role;

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}
