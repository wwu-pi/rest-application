package de.wwu.acse.rest;

import de.wwu.acse.rest.client.AdderRestClient;
import de.wwu.acse.rest.dto.MySum;

public class RestClientApplication {
	
	public static void main(String[] args) {
		// We just initialize it manually for this quick demo. 
		// The AdderRestClient is autowireable and should be used as such
		// For instance, the client can be used in a service class
		AdderRestClient client = new AdderRestClient("http://localhost:8080/");
		MySum sum1 = client.addRequestWithGet(4, 2);
		System.out.println("Computed first sum: " + sum1);
		MySum sum2 = client.addRequestWithPost(42, 1337);
		System.out.println("Computed second sum: " + sum2);
	}

}
