package io.switchbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/echo")
public class EchoController {

	private static final Logger log = LoggerFactory.getLogger(EchoController.class);

	private RestTemplate restTemplate;

	public EchoController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostMapping
	String echo(@RequestBody String message) {
		log.info("Sending echo message: {}", message);

		ResponseEntity<String> response = restTemplate
				.postForEntity("http://chamber:8080/chamber", message, String.class);

		return response.getBody();
	}

}
