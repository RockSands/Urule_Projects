package com.urule.entity;

import com.bstek.urule.model.Label;

public class Order {
	@Label("名称")
	private String name;
	@Label("价格")
	private float price;
	@Label("数量")
	private int amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
