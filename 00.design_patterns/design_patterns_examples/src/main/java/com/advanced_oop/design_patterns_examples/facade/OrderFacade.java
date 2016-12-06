package com.advanced_oop.design_patterns_examples.facade;

public class OrderFacade {

	private Inventory inventory;
	private Payment payment;

	public OrderFacade() {
		this.inventory = new Inventory();
		this.payment = new Payment();
	}

	public void placeOrder(String orderID) {
		System.out.println("facade step1: " + inventory.checkInventory(orderID) + "\nfacade step2: "
				+ payment.deductPayment(orderID));
	}
}
