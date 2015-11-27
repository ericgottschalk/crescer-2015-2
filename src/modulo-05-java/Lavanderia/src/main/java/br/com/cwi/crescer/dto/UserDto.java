package br.com.cwi.crescer.dto;

import org.hibernate.validator.constraints.NotBlank;

public class UserDto {
	
	@NotBlank
	public String username;
	
	@NotBlank
	public String password;
	
	public Role role;
	
	public String auth;
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public enum Role{
		ROLE_USER, ROLE_ADMIN
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
