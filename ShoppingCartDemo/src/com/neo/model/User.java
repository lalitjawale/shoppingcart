package com.neo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Table(name="user")
@Entity
public class User implements Serializable
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String emailId;
	@Column
	private String contactNumber;
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Billing> billings;
	
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/*@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", emailId=" + emailId + ", contactNumber="
				+ contactNumber + ",  getId()="
				+ getId() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getEmailId()="
				+ getEmailId() + ", getContactNumber()=" + getContactNumber()
				+ ",  getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}*/
	
	public void setBillings(Set<Billing> billings) {
		this.billings = billings;
	} 
	
	public Set<Billing> getBillings() {
		return billings;
	}
	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", billings=" + billings + ", getId()=" + getId()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getEmailId()="
				+ getEmailId() + ", getContactNumber()=" + getContactNumber() + ", getBillings()=" + getBillings()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
