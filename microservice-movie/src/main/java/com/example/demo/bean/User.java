package com.example.demo.bean;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户信息描述")
public class User {
	
	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("用户名")
	private String username;
	
	@ApiModelProperty("真实姓名")
	private String name;
	
	@ApiModelProperty("年龄")
	private Integer age;
	
	@ApiModelProperty("余额")
	private BigDecimal balance;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", balance=" + balance
				+ "]";
	}

}
