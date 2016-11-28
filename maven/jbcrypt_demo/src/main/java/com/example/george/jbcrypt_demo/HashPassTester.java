package com.example.george.jbcrypt_demo;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassTester {

	public static void main(String[] args) {
		String password = "mySecr3tP@ssword!";

		// Hash a password for the first time
		String hashedSimple = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println("hashedSimple: " + hashedSimple);

		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		System.out.println("hashed: " + hashed);
		hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		System.out.println("hashed: " + hashed);

		// Check that an unencrypted password matches one that has
		// previously been hashed
		String wrongPassword = "mySecr3tP@ssword1";
		if (BCrypt.checkpw(wrongPassword, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");

		String correctPassword = "mySecr3tP@ssword!";
		if (BCrypt.checkpw(correctPassword, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}
}
