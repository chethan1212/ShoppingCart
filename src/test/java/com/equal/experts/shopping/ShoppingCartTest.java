package com.equal.experts.shopping;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert; 
import org.junit.Test;

public class ShoppingCartTest {
	
	ShoppingCart cart = new ShoppingCart();
	
	@Test
	public void testAddig5DoveSoaps() {
		Product product = new Product("Dove Soap", 39.99f);
		ShoppingItem item = new ShoppingItem(product, 5);
		ActionResult result = cart.addToCartAndTotal(item);
		Assert.assertEquals(199.95f, cart.getTotalPrice(),0.00f);
		Assert.assertEquals("Dove Soap", cart.getShoppingItems().get(0).getProduct().getProductName());
		Assert.assertEquals(Constants.SUCCESS_STATUS, result.getStatus());
		Assert.assertTrue(result.getErrorCodes() == null);
		
	}
	
	@Test
	public void testAddig5and3DoveSoaps() {
		Product product1 = new Product("Dove Soap", 39.99f);
		ShoppingItem item = new ShoppingItem(product1, 5);
		ActionResult result = cart.addToCartAndTotal(item);
		Product product2 = new Product("Dove Soap", 39.99f);
		ShoppingItem item2 = new ShoppingItem(product2, 3);
		result = cart.addToCartAndTotal(item2);
		Assert.assertEquals(319.92f, cart.getTotalPrice(),0.00f);
		Assert.assertEquals("Dove Soap", cart.getShoppingItems().get(0).getProduct().getProductName());
		Assert.assertEquals(8, cart.getShoppingItems().get(0).getCount());
		Assert.assertEquals(1, cart.getShoppingItems().size());
		Assert.assertEquals(Constants.SUCCESS_STATUS, result.getStatus());
		Assert.assertTrue(result.getErrorCodes() == null);
		
	}
	
	@Test
	public void testAddigTwoProducts() {
		Product product1 = new Product("ABC", 39);
		ShoppingItem item = new ShoppingItem(product1, 1);
		ActionResult result = cart.addToCartAndTotal(item);
		Product product2 = new Product("XYZ", 29);
		ShoppingItem item2 = new ShoppingItem(product2, 1);
		result = cart.addToCartAndTotal(item2);
		Assert.assertEquals(68.00f, cart.getTotalPrice(),0.00f);
		Assert.assertEquals("ABC", cart.getShoppingItems().get(0).getProduct().getProductName());
		Assert.assertEquals("XYZ", cart.getShoppingItems().get(1).getProduct().getProductName());
		Assert.assertEquals(2, cart.getShoppingItems().size());
		Assert.assertEquals(Constants.SUCCESS_STATUS, result.getStatus());
		Assert.assertTrue(result.getErrorCodes() == null);
		
	}
	
	@Test
	public void testAddingNull() {
		try {
			cart.addToCartAndTotal(null);
		} catch (InvalidInputException e) {
			Assert.assertEquals("ShoppingItem is null",e.getMessage());
		}
	}
	
	@Test
	public void testAddingEmptyShoppingItem() {
		ShoppingItem item = new ShoppingItem(null, 5);
		try {
			cart.addToCartAndTotal(item);
		} catch (InvalidInputException e) {
			Assert.assertEquals("Product null in shopping item object",e.getMessage());
		}
	}
	
	@Test
	public void testAddingInvalidShoppingItem() {
		ShoppingItem item = new ShoppingItem(new Product("", 0.0f), 5);
		ActionResult result = cart.addToCartAndTotal(item);
		Assert.assertEquals(Constants.VALIDATION_ERROR, result.getStatus());
		assertTrue(!result.getErrorCodes().isEmpty());
	}
	
	

}
