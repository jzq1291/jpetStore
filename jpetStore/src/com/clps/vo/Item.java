package com.clps.vo;

// Generated 2018-1-22 10:21:34 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Item generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "item", catalog = "jpetStore")
public class Item implements java.io.Serializable {

	private String itemid;
	private String productid;
	private BigDecimal listprice;
	private BigDecimal unitcost;
	private Integer supplier;
	private String status;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;

	public Item() {
	}

	public Item(String itemid, String productid) {
		this.itemid = itemid;
		this.productid = productid;
	}

	
	public Item(String itemid, String productid, BigDecimal listprice,
			BigDecimal unitcost, Integer supplier, String status, String attr1,
			String attr2, String attr3, String attr4, String attr5) {
		this.itemid = itemid;
		this.productid = productid;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.supplier = supplier;
		this.status = status;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.attr4 = attr4;
		this.attr5 = attr5;
	}

	@Id
	@Column(name = "itemid", unique = true, nullable = false, length = 10)
	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	@Column(name = "productid", nullable = false, length = 10)
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	@Column(name = "listprice", precision = 10)
	public BigDecimal getListprice() {
		return this.listprice;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	@Column(name = "unitcost", precision = 10)
	public BigDecimal getUnitcost() {
		return this.unitcost;
	}

	public void setUnitcost(BigDecimal unitcost) {
		this.unitcost = unitcost;
	}

	@Column(name = "supplier")
	public Integer getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}

	@Column(name = "status", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "attr1", length = 80)
	public String getAttr1() {
		return this.attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	@Column(name = "attr2", length = 80)
	public String getAttr2() {
		return this.attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	@Column(name = "attr3", length = 80)
	public String getAttr3() {
		return this.attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	@Column(name = "attr4", length = 80)
	public String getAttr4() {
		return this.attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	@Column(name = "attr5", length = 80)
	public String getAttr5() {
		return this.attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", productid=" + productid
				+ ", listprice=" + listprice + ", unitcost=" + unitcost
				+ ", supplier=" + supplier + ", status=" + status + ", attr1="
				+ attr1 + "]";
	}
	
}
