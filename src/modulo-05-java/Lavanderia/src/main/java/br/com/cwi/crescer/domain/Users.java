package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cwi.crescer.common.Base;

@Entity
@Table(name = "users")
public class Users extends Base{
	
	@Id
	@Column(name = "username", length = 100)
	private String username;
	
	@Column(name = "password", length = 32)
	@Basic(optional=false)
	private String password;
	
	@Column(name = "enabled")
	@Basic(optional=false)
	private Boolean enabled;;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}