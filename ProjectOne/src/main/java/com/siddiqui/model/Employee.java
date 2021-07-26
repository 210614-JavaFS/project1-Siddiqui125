package com.siddiqui.model;

public class Employee {
	int ers_id;
	int user_role_id;
	String username;
	String password;
	String firstname;
	String lastname;
	String email;

	public Employee(int user_role_id, String username, String password, String firstname, String lastname,
			String email) {
		super();
		this.user_role_id = user_role_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public Employee() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getErs_id() {
		return ers_id;
	}

	public void setErs_id(int ers_id) {
		this.ers_id = ers_id;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
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

	@Override
	public String toString() {
		return "Employee [ers_id=" + ers_id + ", user_role_id=" + user_role_id + ", username=" + username
				+ ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ "]";
	}	
	
	
}
