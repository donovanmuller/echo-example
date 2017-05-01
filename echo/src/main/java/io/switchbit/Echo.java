package io.switchbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "chamber", fallback = Echo.EchoFallback.class)
public interface Echo {

	@PostMapping("/chamber")
	String send(String message);

	@Component
	class EchoFallback implements Echo {

		private static final Logger log = LoggerFactory.getLogger(EchoFallback.class);

		@Override
		public String send(String message) {
			log.warn("Hmm, looks like no one's home for echoing message [{}] :(",
					message);

			return message;
		}
	}
}
