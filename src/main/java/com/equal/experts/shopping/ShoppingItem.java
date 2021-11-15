package com.equal.experts.shopping;

/**
 * Each product and the count to be added.
 *
 */
public class ShoppingItem {
	
	private Product product;
	
	private int count;

	public ShoppingItem(Product product, int count) {
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}
	
	public void addToCount(int newCount) {
		count = count + newCount ;
	}
	

}
