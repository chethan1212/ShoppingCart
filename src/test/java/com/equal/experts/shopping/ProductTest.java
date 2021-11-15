package com.equal.experts.shopping;

import org.junit.Assert; 
import org.junit.Test;

public class ProductTest {
	
	@Test
	public void testEquals() {
		Product product1 = new Product("Abc", 19.99f);
		Product product2 = new Product("Abc", 19.99f);
		Assert.assertTrue(product1.equals(product2));
		Assert.assertTrue(product1.equals(product1));
	}
	
	@Test
	public void testNotEquals() {
		Product product1 = new Product("Abc", 19.99f);
		Product product2 = new Product("xyz", 19.99f);
		Product product3 = new Product("Abc", 9.99f);
		Assert.assertTrue(!product1.equals(product2));
		Assert.assertTrue(!product1.equals(product3));
	}

}
