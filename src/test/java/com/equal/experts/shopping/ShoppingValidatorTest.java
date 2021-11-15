package com.equal.experts.shopping;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ShoppingValidatorTest {
	
	private ShoppingItemValidator shoppingItemValidator = new ShoppingItemValidator();
	
	@Test
	public void testInvalidInput() {
		ShoppingItem item1 = new ShoppingItem(new Product(null, 0.00f), 0);
		ShoppingItem item2 = new ShoppingItem(new Product("", -0.00f), -0);
		List<String> errors = shoppingItemValidator.validateShoppingItem(item1);
		assertTrue(errors.contains(Constants.ERR_ITEM_COUNT_INVALID));
		assertTrue(errors.contains(Constants.ERR_PRODUCT_NAME_MISSING));
		assertTrue(errors.contains(Constants.ERR_PRODUCT_PRICE_INVALID));
		errors = shoppingItemValidator.validateShoppingItem(item2);
		assertTrue(errors.contains(Constants.ERR_ITEM_COUNT_INVALID));
		assertTrue(errors.contains(Constants.ERR_PRODUCT_NAME_MISSING));
		assertTrue(errors.contains(Constants.ERR_PRODUCT_PRICE_INVALID));
	}

}
