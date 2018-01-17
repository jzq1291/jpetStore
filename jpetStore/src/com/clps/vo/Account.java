package com.clps.vo;

// Generated 2018-1-12 9:45:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account", catalog = "jpetStore")
public class Account implements java.io.Serializable {

	private String userid;
	private String email;
	private String firstname;
	private String lastname;
	private String status;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;

	public Account() {
	}

	public Account(String userid, String email, String firstname,
			String lastname, String addr1, String city, String state,
			String zip, String country, String phone) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr1 = addr1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
	}

	public Account(String userid, String email, String firstname,
			String lastname, String status, String addr1, String addr2,
			String city, String state, String zip, String country, String phone) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
	}

	@Id
	@Column(name = "userid", unique = true, nullable = false, length = 80)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "email", nullable = false, length = 80)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "firstname", nullable = false, length = 80)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false, length = 80)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "status", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "addr1", nullable = false, length = 80)
	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	@Column(name = "addr2", length = 40)
	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	@Column(name = "city", nullable = false, length = 80)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false, length = 80)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zip", nullable = false, length = 20)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "country", nullable = false, length = 20)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone", nullable = false, length = 80)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Account [userid=" + userid + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname
				+ ", status=" + status + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + ", phone=" + phone + "]";
	}
}
