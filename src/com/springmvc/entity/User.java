package com.springmvc.entity;

public class User {
	private Integer id;
	private String name;
	private Integer gender; // 性别：0-男，1-女
	private int age;
	
	public User() {
		
	}
	
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
//	}
	
}
