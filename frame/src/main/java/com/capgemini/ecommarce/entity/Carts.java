package com.capgemini.ecommarce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cartitem_Table1")
public class Carts {

	@Id
	
	private int id;
	
	private int totalamount;
	private String paymenttype;
	
	@OneToMany
	private List<Frame> frame;
	
	
	public Carts() {
		
	}
	
	

	public Carts(int id, int totalamount, String paymenttype, List<Frame> frame) {
		super();
		this.id = id;
		this.totalamount = totalamount;
		this.paymenttype = paymenttype;
		this.frame = frame;
	}



	public List<Frame> getFrame() {
		return frame;
	}

	public void setFrame(List<Frame> frame) {
		this.frame = frame;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
