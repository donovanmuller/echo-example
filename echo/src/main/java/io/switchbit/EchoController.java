package io.switchbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

	private static final Logger log = LoggerFactory.getLogger(EchoController.class);

	private Echo echo;

	public EchoController(Echo echo) {
		this.echo = echo;
	}

	@PostMapping
	String echo(@RequestBody String message) {
		log.info("Sending echo message: {}", message);

		return echo.send(message);
	}
}
