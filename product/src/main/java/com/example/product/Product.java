package com.example.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "productlist")
public class Product {
	private @Id @GeneratedValue long id;
	private @NotBlank String Productname;
	private @NotBlank float price;

	public Product() {
	}

	public Product(String Productname, float price) {
		this.Productname = Productname;
		this.price = price;

	}

	public long getId() {
		return id;
	}

	public String getProductname() {
		return Productname;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, Productname, price);
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", Productname='" + Productname + '\'' +

				", price=" + price + '}';
	}
}