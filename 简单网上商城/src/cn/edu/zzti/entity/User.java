package cn.edu.zzti.entity;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private Date loginTime;
	private PersonalInfo pi;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public PersonalInfo getPi() {
		return pi;
	}
	public void setPi(PersonalInfo pi) {
		this.pi = pi;
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
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public User(String username, String password, Date loginTime) {
		super();
		this.username = username;
		this.password = password;
		this.loginTime = loginTime;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(){
		
	}@Override
	public String toString() {
		return "[username:"+username+",password:"+password+"]";
	}
}
