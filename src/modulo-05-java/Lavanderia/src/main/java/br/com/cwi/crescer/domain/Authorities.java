package br.com.cwi.crescer.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.cwi.crescer.common.Base;

@Entity
@Table(name = "authorities")
public class Authorities extends Base{

	@EmbeddedId
	private AuthoritiesId authoritiesId;

	public AuthoritiesId getAuthoritiesId() {
		return authoritiesId;
	}

	public void setAuthoritiesId(AuthoritiesId authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
}