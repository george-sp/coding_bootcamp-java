package com.exercise3.george;

public class PrimeNumber {

	private int number;
	
	public PrimeNumber() {}
	
	public PrimeNumber(int number) {
		this.number = number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	/**
	 * Checks if the given is prime or not
	 * 
	 * @return True if the number is a prime, otherwise false
	 */
	boolean isPrime() {
	    //check if n is a multiple of 2
	    if (this.number%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=this.number;i+=2) {
	        if(this.number%i==0)
	            return false;
	    }
	    return true;
	}
}
