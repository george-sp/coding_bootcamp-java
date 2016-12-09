package com.advanced_oop.design_patterns_examples.facade;

class Payment {

	public String deductPayment(String orderID) {
		return "Payment deducted successfully for the order with ID: " + orderID;
	}
}
