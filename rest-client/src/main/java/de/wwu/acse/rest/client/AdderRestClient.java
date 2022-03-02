package de.wwu.acse.rest.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.wwu.acse.rest.dto.AddRequest;
import de.wwu.acse.rest.dto.AddResponse;
import de.wwu.acse.rest.dto.MySum;

@Component // This makes AdderRestClient autowireable
public class AdderRestClient {
	private final RestTemplate restTemplate = new RestTemplate();
	private final String adderGetRestUrl;
	private final URI adderPostRestURI;
	
	@Autowired // This constructor will be used by Spring to construct the instance
	public AdderRestClient(
			// With @Value we signify to Spring, that the value of the parameter "url" will be defined 
			// in application.properties with the key adder.url
			@Value("${adder.url}") String url) {
		if (url == null || url.isEmpty() || !url.endsWith("/")) {
			throw new IllegalStateException();
		}
		// %d is a placeholder for ints and is replaced via String.format(...)
		this.adderGetRestUrl = url + "add1?n1=%d&n2=%d";
		try {
			this.adderPostRestURI = new URI(url + "postAdd");
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public MySum addRequestWithGet(int n1, int n2) {
		try {
			MySum result = 
					restTemplate.getForObject(
							// Insert respective values to request-url via String.format(...)
							new URI(String.format(adderGetRestUrl, n1, n2)), 
							MySum.class
					);
			// Mapping is "dynamic", check: restTemplate.getForObject(new URI(String.format(getAdderRestUrl, n1, n2)), Map.class);
			// Also check out @JsonIgnoreProperties!
			return result;
		} catch (URISyntaxException | RestClientException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	public MySum addRequestWithPost(int n1, int n2) {
		try {
			AddRequest addRequest = new AddRequest();
			addRequest.setN1(n1);
			addRequest.setN2(n2);
					
			AddResponse response = restTemplate.postForObject(
					adderPostRestURI, 
					addRequest,
					AddResponse.class);
			
			return response.getSum();
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
}
