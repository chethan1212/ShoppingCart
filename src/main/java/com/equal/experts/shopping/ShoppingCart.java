package com.equal.experts.shopping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the list of shopping items and total price.
 *
 */
public class ShoppingCart {

	private List<ShoppingItem> shoppingItems;

	private float totalPrice = 0.0f;

	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Adds item to cart after validating input and then update the total price.
	 * @param itemsToAdd
	 * @return ActionResult - With either true or false.
	 * @throws - If the input is invalid throws InvalidInputException
	 */
	public ActionResult addToCartAndTotal(ShoppingItem itemsToAdd) {
		ShoppingItemValidator validator = new ShoppingItemValidator();
		List<String> validationErros = validator.validateShoppingItem(itemsToAdd);
		if (!validationErros.isEmpty()) {
			return new ActionResult(Constants.VALIDATION_ERROR, validationErros);
		}
		if (shoppingItems == null) {
			shoppingItems = new ArrayList<ShoppingItem>();
		}
		addToCart(shoppingItems, itemsToAdd);
		float newItemPrice = itemsToAdd.getProduct().getPrice() * itemsToAdd.getCount();
		newItemPrice = newItemPrice + ( newItemPrice * 0.125f);
		totalPrice = totalPrice + newItemPrice;
		totalPrice = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP).floatValue();
		return new ActionResult(Constants.SUCCESS_STATUS, null);
	}

	/**
	 * If the same item exist in the cart update count or else add.
	 * @param shoppingItems
	 * @param itemsToAdd
	 */
	private void addToCart(List<ShoppingItem> shoppingItems, ShoppingItem itemsToAdd) {
		boolean existingProduct = false;
		for (ShoppingItem shoppingItem : shoppingItems) {
			if (shoppingItem.getProduct().equals(itemsToAdd.getProduct())) {
				shoppingItem.addToCount(itemsToAdd.getCount());
				existingProduct = true;
			}
		}
		if (!existingProduct) {
			shoppingItems.add(itemsToAdd);
		}
	}
	
	public List<ShoppingItem> getShoppingItems() {
		return shoppingItems;
	}

}
