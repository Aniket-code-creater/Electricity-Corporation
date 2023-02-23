package com.masai.model;

public class Consumer {
	int consumer_id;
	int admin_id;
	String c_username;
	String c_password;
	String is_active;
	public Consumer() {
		
	}
	public Consumer(int consumer_id, int admin_id, String c_username, String c_password,String is_active) {
		super();
		this.consumer_id = consumer_id;
		this.admin_id = admin_id;
		this.c_username = c_username;
		this.c_password = c_password;
		this.is_active = is_active;
	}
	public int getConsumer_id() {
		return consumer_id;
	}
	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getC_username() {
		return c_username;
	}
	public void setC_username(String c_username) {
		this.c_username = c_username;
	}
	public String getC_password() {
		return c_password;
	}
	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	@Override
	public String toString() {
		return "Consumer [consumer_id=" + consumer_id + ", admin_id=" + admin_id + ", c_username=" + c_username
				+ ", c_password=" + c_password + ", is_active=" + is_active + "]";
	}

	
	
	

}
