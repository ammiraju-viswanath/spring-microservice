package com.vis.learning.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorld {

	@GetMapping("/helloworld")
	public String firstApp() {
		return "Hello Wolrd!";
	}

	@GetMapping("/helloworld/{message}")
	public String firstAppUsingMessage(@PathVariable String message) {
		return String.format("Hello Wolrd! %s", message);
	}

	@GetMapping("/helloworldBean/{message}")
	public HelloWorldBean firstAppUsingMessageUsingBean(@PathVariable String message) {
		return new HelloWorldBean(String.format("Hello Wolrd! %s", message));
	}

}
