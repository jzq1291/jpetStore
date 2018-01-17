package com.clps.vo;

// Generated 2018-1-12 9:45:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bannerdata generated by hbm2java
 */
@Entity
@Table(name = "bannerdata", catalog = "jpetStore")
public class Bannerdata implements java.io.Serializable {

	private String favcategory;
	private String bannername;

	public Bannerdata() {
	}

	public Bannerdata(String favcategory) {
		this.favcategory = favcategory;
	}

	public Bannerdata(String favcategory, String bannername) {
		this.favcategory = favcategory;
		this.bannername = bannername;
	}

	@Id
	@Column(name = "favcategory", unique = true, nullable = false, length = 80)
	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	@Column(name = "bannername")
	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

}