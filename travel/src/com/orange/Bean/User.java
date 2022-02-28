package com.orange.Bean;

/**
 * @Author wff
 */

public class User {
	String user_id;//用户ID
	String user_account;//用户账户
	String user_password;//用户密码
	String user_type;//用户类型
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_account=" + user_account + ", user_password=" + user_password
				+ ", user_type=" + user_type + "]";
	}
	public User() {
		super();
	}
	public User(String user_id, String user_account, String user_password, String user_type) {
		super();
		this.user_id = user_id;
		this.user_account = user_account;
		this.user_password = user_password;
		this.user_type = user_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
}
