package io.switchbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamber")
public class ChamberController {

	private static final Logger log = LoggerFactory.getLogger(ChamberController.class);

	@PostMapping
	String echo(@RequestBody String message) {
		log.info("Echoing message: {}", message);

		return String.format("%s... %s.. %s", message.toUpperCase(), message,
				message.toLowerCase());
	}
}
