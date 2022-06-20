package com.capgemini.sunglasses.model;


import java.util.List;


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
	private List<Sunglass> sunglass;

	
	public Carts() {
		
	}

	public Carts(int id, int totalamount, String paymenttype, List<Sunglass> sunglass) {
		super();
		this.id = id;
		this.totalamount = totalamount;
		this.paymenttype = paymenttype;
		this.sunglass = sunglass;
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

	public List<Sunglass> getSunglass() {
		return sunglass;
	}

	public void setSunglass(List<Sunglass> sunglass) {
		this.sunglass = sunglass;
	}
	
	

	
	
}
