package br.com.cwi.crescer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;


@Embeddable
public class AuthoritiesId implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JoinColumn(name= "username")
    private String username;

    @Column(name="authority", length=30)
    private String authority;

    public AuthoritiesId() {

    }

    public AuthoritiesId(String user, String auth){
        this.username = user;
        this.authority = auth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object obj) {
        AuthoritiesId auth = (AuthoritiesId)obj;
        return auth.username == this.username
                && auth.authority == this.authority;
    }

    @Override
    public int hashCode() {
        return (int)(serialVersionUID +(username.hashCode() + authority.hashCode()));
    }
}