package com.trav.b2c.po;

import java.io.Serializable;
import java.util.Date;

public class UpdatableBean implements Serializable {
	private static final long serialVersionUID = 1L;

	protected long objectUid;
	protected String isActive = "Y";
	protected Date dateCreated;
	protected long createdBy;
	protected Date dateUpdated;
	protected long updatedBy;
	
	public long getObjectUid() {
		return objectUid;
	}

	public void setObjectUid(long objectUid) {
		this.objectUid = objectUid;
	}

	public boolean isActive() {
		return "Y".equals(isActive);
	}

	public void setActive(boolean isActive) {
		this.isActive = (isActive ? "Y" : "N");
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
}
