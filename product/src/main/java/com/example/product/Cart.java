package com.example.product;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cart")
public class Cart {
	private @Id @GeneratedValue long id;
	private @NotBlank String transactionid;
	private @NotBlank String user_id;
	private @NotBlank String productname;
	private @NotBlank float price;

	public Cart() {
	}

	public Cart(String transactionid, String user_id, String productname, float price) {
		this.transactionid = transactionid;
		this.user_id = user_id;
		this.productname = productname;
		this.price = price;
System.out.println(productname);
	}

	//getters
	public String gettransactionid() {
		return transactionid;
	}

	public String getuser_id() {
		return user_id;
	}

	public String getproductname() {
		return productname;
	}

	public float getPrice() {
		return price;
	}
	
	//setters
	public void settransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public void setuser_id(String user_id) {
		this.user_id= user_id;
	}

	public void setproductname(String productname) {
		this.productname= productname;
	}

	public void setPrice(float price) {
		this.price= price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionid, user_id, productname, price);
	}

	@Override
	public String toString() {
		return "Product{" + "transactionid=" + transactionid + ", user_id=" + user_id + ", productname='"
				+ productname + '\'' + ", price=" + price + '}';
	}
}