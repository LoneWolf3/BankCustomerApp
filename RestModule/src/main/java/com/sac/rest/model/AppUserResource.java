package com.sac.rest.model;

import com.sac.model.AppUser;

public class AppUserResource extends DefaultResource implements AppUser {

	private String username;
	private String password;

	private String email;

	UserRoleResource roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoleResource getRoles() {
		return roles;
	}

	public void setRoles(UserRoleResource roles) {
		this.roles = roles;
	}

	public AppUserResource() {
		super();
	}

	public AppUserResource(AppUser user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
	}

}
