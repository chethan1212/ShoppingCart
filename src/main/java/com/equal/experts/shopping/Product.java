package com.equal.experts.shopping;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Product name and price. Expects a non null non empty name and positive price.
 *
 */
public class Product {

	// private int productId;

	private String productName;

	private float price;

	public Product(String productName, float price) {
		this.productName = productName;
		this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).floatValue();
	}

	public String getProductName() {
		return productName;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Product other = (Product) obj;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (!productName.equals(other.productName))
			return false;
		return true;
	}

}
