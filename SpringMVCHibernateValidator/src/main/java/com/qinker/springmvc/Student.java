package com.qinker.springmvc;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Student {

	@Range(min=1,max=150)//规定范围
	private Integer age;
	@NotNull//非空
	private Integer id;
	
	private String name;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
	
	
	
}
