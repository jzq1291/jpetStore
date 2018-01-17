package com.clps.vo;

// Generated 2018-1-12 9:45:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signon", catalog = "jpetStore")
public class Signon implements java.io.Serializable {

	private String username;
	private String password;

	public Signon() {
	}

	public Signon(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 25)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 25)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Signon [username=" + username + ", password=" + password + "]";
	}

	
}
