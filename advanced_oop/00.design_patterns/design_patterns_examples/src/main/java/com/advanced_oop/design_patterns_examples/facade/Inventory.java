package com.advanced_oop.design_patterns_examples.facade;

class Inventory {

	public String checkInventory(String orderID) {
		return "Inventory checked for the order with ID: " + orderID;
	}
}
