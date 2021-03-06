package com.clps.vo;

// Generated 2018-1-12 9:45:46 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Lineitem generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "lineitem", catalog = "jpetStore")
public class Lineitem implements java.io.Serializable {

	private LineitemId id;
	private String itemid;
	private int quantity;
	private BigDecimal unitprice;
	
	

	public Lineitem() {
		
	}

	public Lineitem(LineitemId id, String itemid, int quantity,
			BigDecimal unitprice) {
		this.id = id;
		this.itemid = itemid;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "orderid", column = @Column(name = "orderid", nullable = false)),
			@AttributeOverride(name = "linenum", column = @Column(name = "linenum", nullable = false)) })
	public LineitemId getId() {
		return this.id;
	}

	public void setId(LineitemId id) {
		this.id = id;
	}

	@Column(name = "itemid", nullable = false, length = 10)
	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "unitprice", nullable = false, precision = 10)
	public BigDecimal getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}
	
	
}
