package com.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import trivia.Md5Cipher;

@Entity
@Table(name = "persons")
public class Person {
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column
	private String lastname;
	@Column
	private Date birthdate;
	@Column
	private int documentno;
	@Column
	private String doctype;

	// Constructor sin parametros
	public Person() {
	}

	// Constructor con parametros
	public Person(String name, String lastname, Date birthdate, int docno, String doctype) {
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.documentno = docno;
		this.doctype = doctype;
	}

	public void setId(int newId) {
		this.id = newId;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setLastname(String newLastName) {
		this.lastname = newLastName;
	}

	public void setBirthdate(Date newBirthDate) {
		this.birthdate = newBirthDate;
	}

	public void setDocumentno(int newDocumentNo) {
		this.documentno = newDocumentNo;
	}

	public void setDoctype(String newDocType) {
		this.doctype = newDocType;
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getLastname() {
		return this.lastname;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public int getDocumentno() {
		return this.documentno;
	}

	public String getDoctype() {
		return this.doctype;
	}


	@Override
	public String toString() {
		String persona = "";
		persona += ", Name: " + this.name + ", Lastname: " + this.lastname
		    + ", Birthdate: " + this.birthdate.toString();
		persona += ", Documentno: " + this.documentno + ", Doctype_id: " + this.doctype;

		return persona;
	}

	public boolean repOk() {
		return true;
	}
}
