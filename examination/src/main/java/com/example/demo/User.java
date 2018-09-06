package com.example.demo;

public class User {
	String name;
	String password;
	String tel;
	String email;
	int grade;
	int pority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getPority() {
		return pority;
	}

	public void setPority(int pority) {
		this.pority = pority;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", tel=" + tel + ", email=" + email + ", grade="
				+ grade + ", pority=" + pority + "]";
	}

}
