package com.capgemini.lens.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cartitem_Table1")
public class Carts {

	@Id
	
	private int id;
	
	private int totalamount;
	private String paymenttype;
	private List<Lens> lens;
	
	public Carts() {
		
	}
	
	

	public Carts(int id, int totalamount, String paymenttype,
			List<Lens> lens) {
		super();
		this.id = id;
		this.totalamount = totalamount;
		this.paymenttype = paymenttype;
		this.lens = lens;
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
