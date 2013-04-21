package com.trav.b2c.po;

public class Area extends UpdatableBean {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String municipality;// ÊÐ
	private String province;// Ê¡

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
