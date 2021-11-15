package com.equal.experts.shopping;

import java.util.List;

/**
 * Result of add to cart Action.
 *
 */
public class ActionResult {
	
	private String status;
	
	private List<String> errorCodes;

	public ActionResult(String status, List<String> errorCodes) {
		super();
		this.status = status;
		this.errorCodes = errorCodes;
	}

	public String getStatus() {
		return status;
	}

	public List<String> getErrorCodes() {
		return errorCodes;
	}

}
