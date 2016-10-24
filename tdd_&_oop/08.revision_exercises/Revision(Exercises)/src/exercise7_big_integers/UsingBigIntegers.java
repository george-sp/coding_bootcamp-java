package exercise7_big_integers;

import java.math.BigInteger;

public class UsingBigIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Do not modify these lines of code
		BigInteger b1 = new BigInteger("987654321987654321000000000");
		BigInteger b2 = new BigInteger("987654321987654321000000000");

	    BigInteger product = multiplyBigIntegers(b1, b2);
	    BigInteger sum = sumBigIntegers(b1, b2);


	    //Check if your results are equal to productResults and sumResult
	    BigInteger productResult = new BigInteger("975461059740893157555403139789971041000000000000000000");
	    BigInteger sumResult = new BigInteger("1975308643975308642000000000");
	    System.out.println(productResult + "\n" + product);
	    System.out.println(sumResult + "\n" + sum);
	}
	
	public static BigInteger sumBigIntegers(BigInteger b1, BigInteger b2) {
		return b1.add(b2);
	}
	
	public static BigInteger multiplyBigIntegers(BigInteger b1, BigInteger b2) {
		return b1.multiply(b2);
	}

}
