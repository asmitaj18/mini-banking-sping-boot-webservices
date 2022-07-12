package com.minibanking.rest.webservices.resfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderSetupNewUser {

	public static void main(String a[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("test@!23");
		System.out.println(encoded);
		}
}
