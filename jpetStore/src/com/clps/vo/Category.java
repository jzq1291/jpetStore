package com.clps.vo;

// Generated 2018-1-12 9:45:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "jpetStore")
public class Category implements java.io.Serializable {

	private String catid;
	private String name;
	private String descn;

	public Category() {
	}

	public Category(String catid) {
		this.catid = catid;
	}

	public Category(String catid, String name, String descn) {
		this.catid = catid;
		this.name = name;
		this.descn = descn;
	}

	@Id
	@Column(name = "catid", unique = true, nullable = false, length = 10)
	public String getCatid() {
		return this.catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	@Column(name = "name", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "descn")
	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	@Override
	public String toString() {
		return "Category [catid=" + catid + ", name=" + name + ", descn="
				+ descn + "]";
	}
	
	
}