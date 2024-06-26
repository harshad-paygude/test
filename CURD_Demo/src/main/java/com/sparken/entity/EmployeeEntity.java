
package com.sparken.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "EmployeeEntity")

@Table(name = "employee")
public class EmployeeEntity {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "e_id")
	int id;

	@Column(name = "e_fname")
	String firstname;

	@Column(name = "e_lname")
	String lastname;

	@Column(name = "e_mobileno")
	String mobileno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", employeeno=" + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobileno=" + mobileno + "]";
	}

}
