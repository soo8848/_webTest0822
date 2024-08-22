package com.board.db;

public class UserDto {
	private int userNum = 0; // 사용자 번호
	private String id = ""; // 사용자 ID
	private String password = ""; // 비밀번호
	private String name = ""; // 사용자 이름
	private String role = ""; // 사용자 역할
	private String email = ""; // 사용자 이메일

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [userNum=" + userNum + ", id=" + id + ", password=" + password + ", name=" + name + ", role="
				+ role + ", email=" + email + "]";
	}
}
