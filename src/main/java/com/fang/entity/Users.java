package com.fang.entity;
//≤‚ ‘¿‡
public class Users {

	private int id;
	
	private String userName;
	
	private String password;
	
	private int age;
	
	public Users() {
		super();
	}

	public Users(int id, String username, String password, int age) {
		super();
		this.id = id;
		this.userName = username;
		this.password = password;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + userName + ", password=" + password + ", age=" + age + "]";
	}
	
	
}
