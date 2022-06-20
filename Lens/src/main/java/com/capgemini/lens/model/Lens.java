package com.capgemini.lens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lens_Table")
public class Lens {

	@Id // primary key
	@Column(name = "lensid") // column name in database
	private int lensId;

	@Column(name = "brand")
	private String lensBrand;

	@Column(name = "price")
	private int lensPrice;

	@Column(name = "image")
	private String lensimage;

	@Column(name = "shape")
	private String lensShape;

	@Column(name = "color")
	private String lensColor;

	@Column(name = "quantity")
	private int lensQuntity;


	// Empty constructor
	public Lens() {
		
	}
	
	@ManyToOne
	private Carts cart;
	
	
	public Lens(int lensId, String lensBrand, int lensPrice, String lensimage, String lensShape, String lensColor,
			int lensQuntity, Carts cart) {
		super();
		this.lensId = lensId;
		this.lensBrand = lensBrand;
		this.lensPrice = lensPrice;
		this.lensimage = lensimage;
		this.lensShape = lensShape;
		this.lensColor = lensColor;
		this.lensQuntity = lensQuntity;
		this.cart = cart;
	}

	// getter and setter
	
	public int getLensId() {
		return lensId;
	}

	public Carts getCart() {
		return cart;
	}

	public void setCart(Carts cart) {
		this.cart = cart;
	}

	public void setLensId(int lensId) {
		this.lensId = lensId;
	}

	public String getLensBrand() {
		return lensBrand;
	}

	public void setLensBrand(String lensBrand) {
		this.lensBrand = lensBrand;
	}

	public int getLensPrice() {
		return lensPrice;
	}

	public void setLensPrice(int lensPrice) {
		this.lensPrice = lensPrice;
	}

	public String getLensimage() {
		return lensimage;
	}

	public void setLensimage(String lensimage) {
		this.lensimage = lensimage;
	}

	public String getLensShape() {
		return lensShape;
	}

	public void setLensShape(String lensShape) {
		this.lensShape = lensShape;
	}

	public String getLensColor() {
		return lensColor;
	}

	public void setLensColor(String lensColor) {
		this.lensColor = lensColor;
	}

	public int getLensQuntity() {
		return lensQuntity;
	}

	public void setLensQuntity(int lensQuntity) {
		this.lensQuntity = lensQuntity;
	}

}
