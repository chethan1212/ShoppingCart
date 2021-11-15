package com.equal.experts.shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * Validates the input item before adding to cart 
 *
 */
public class ShoppingItemValidator {

	public List<String> validateShoppingItem(ShoppingItem shoppingItem) {
		if(shoppingItem == null) {
			throw new InvalidInputException("ShoppingItem is null");
		}else if(shoppingItem.getProduct()==null) {
			throw new InvalidInputException("Product null in shopping item object");
		}
		List<String> errorCodes = new ArrayList<String>();
		if(shoppingItem.getCount() <= 0 ) {
			errorCodes.add(Constants.ERR_ITEM_COUNT_INVALID);
		}
		if(shoppingItem.getProduct().getProductName() == null 
				|| shoppingItem.getProduct().getProductName().trim() == "") {
			errorCodes.add(Constants.ERR_PRODUCT_NAME_MISSING);
		}
		if(shoppingItem.getProduct().getPrice() <= 0) {
			errorCodes.add(Constants.ERR_PRODUCT_PRICE_INVALID);
		}
		return errorCodes;
	}

}
