package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.facade.OrderFacade;

public class FacadeClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Facade =====");
		
		OrderFacade orderFacade = new OrderFacade();
		orderFacade.placeOrder("AB132455");
	}
}
