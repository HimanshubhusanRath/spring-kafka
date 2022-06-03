package com.hr.domain.common;

public class Domain {

	private String domain;
	private String create_date;
	private String update_date;
	private String country;
	private boolean isDead;
	
	public Domain() {
		super();
	}

	public Domain(String domain, String create_date, String update_date, String country, boolean isDead) {
		super();
		this.domain = domain;
		this.create_date = create_date;
		this.update_date = update_date;
		this.country = country;
		this.isDead = isDead;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
}
