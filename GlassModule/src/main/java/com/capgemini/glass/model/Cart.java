package com.capgemini.glass.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {


	@Id
	private int id;	
	private int totalamount;
	private String paymenttype;
	
	@OneToMany
	private List<Glass> glass;

	public Cart(int id, int totalamount, String paymenttype, List<com.capgemini.glass.model.Glass> glass) {
		super();
		this.id = id;
		this.totalamount = totalamount;
		this.paymenttype = paymenttype;
		this.glass = glass;
	}
	

	public Cart() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public List<Glass> getGlass() {
		return glass;
	}

	public void setGlass(List<Glass> glass) {
		this.glass = glass;
	}
}
