package com.rdyang.mall.manager.entity;

public class Stock {
	private Integer id;
	private String name;
	private Long amount;
	
	public Stock() {
		super();
	}
	
	public Stock(Integer id, String name, Long amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
