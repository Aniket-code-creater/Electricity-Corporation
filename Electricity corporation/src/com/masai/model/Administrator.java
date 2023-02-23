package com.masai.model;

public class Administrator {
	int admin_id;
	String ad_username;
	String ad_email;
	String ad_password;
	public Administrator() {
		
	}
	public Administrator(int admin_id, String ad_username, String ad_email, String ad_password) {
		super();
		this.admin_id = admin_id;
		this.ad_username = ad_username;
		this.ad_email = ad_email;
		this.ad_password = ad_password;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAd_username() {
		return ad_username;
	}
	public void setAd_username(String ad_username) {
		this.ad_username = ad_username;
	}
	public String getAd_email() {
		return ad_email;
	}
	public void setAd_email(String ad_email) {
		this.ad_email = ad_email;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	@Override
	public String toString() {
		return "Administrator [admin_id=" + admin_id + ", ad_username=" + ad_username + ", ad_email=" + ad_email
				+ ", ad_password=" + ad_password + "]";
	}
	
	
	
	

}
