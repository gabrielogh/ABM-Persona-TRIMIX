package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "message_id")
	private long id;
	@Column
	private Date created;
	@Column
	private long createdby;
	@Column
	private Date updated;
	@Column
	private long updatedby;
	@Column
	private boolean isactive;
	@Column
	private String searchkey;

	// Constructor sin parametros
	public Message() {
	}

	// Constructor con parametros
	public Message(String value) {
		this.searchkey = value;
	}

	public void setId(long newId) {
		this.id = newId;
	}

	public void setCreatedat(Date newCreatedAt) {
		this.created = newCreatedAt;
	}

	public void setCreatedby(long newCreatedBy) {
		this.createdby = newCreatedBy;
	}

	public void setUpdated(Date newUpdated) {
		this.updated = newUpdated;
	}

	public void setUpdatedby(long newUpdatedBy) {
		this.updatedby = newUpdatedBy;
	}

	public void setIsactive(boolean newIsActive) {
		this.isactive = newIsActive;
	}

	public void setValue(String newValue) {
		this.searchkey = newValue;
	}

	public long getId() {
		return this.id;
	}

	public Date getCreatedat() {
		return this.created;
	}

	public long getCreatedby() {
		return this.createdby;
	}

	public Date getUpdatedat() {
		return this.updated;
	}

	public long getUpdatedby() {
		return this.updatedby;
	}

	public boolean getIsactive() {
		return this.isactive;
	}

	public String getValue() {
		return this.searchkey;
	}

	@Override
	public String toString() {
		String message = "";

		message += "Createdat: " + this.created.toString() + ", Createdby: " + this.createdby + ", Updatedat: "
		    + this.updated.toString() + ", Updatedby " + this.updatedby;
		message += ", Isactive: " + this.isactive + ", Value: " + this.searchkey;
		return message;
	}

	public boolean repOk() {
		return true;
	}
}
