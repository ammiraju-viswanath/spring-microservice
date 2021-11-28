package com.vis.learning.user.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserVersionController {

	// URI version - Twitter
	@GetMapping("v1/person")
	public UserV1 aGetPersonV1Uri() {
		return new UserV1("Viswanath Ammiraju");
	}

	@GetMapping("v2/person")
	public UserV2 aGetPersonV2Uri() {
		return new UserV2(new Name("Viswanath", "Ammiraju"));
	}

	// Request Parameter version - Amazon
	@GetMapping(value = "person/param", params = "verson=1")
	public UserV1 bGetPersonV1Param() {
		return new UserV1("Viswanath Ammiraju");
	}

	@GetMapping(value = "person/param", params = "verson=2")
	public UserV2 bGetPersonV2Param() {
		return new UserV2(new Name("Viswanath", "Ammiraju"));
	}

	// Header version - Microsoft
	@GetMapping(value = "person/header", headers = "API-VERSION-1")
	public UserV1 cGetPersonV1Header() {
		return new UserV1("Viswanath Ammiraju");
	}

	@GetMapping(value = "person/header", headers = "API-VERSION-2")
	public UserV2 cGetPersonV2Header() {
		return new UserV2(new Name("Viswanath", "Ammiraju"));
	}

	// Produce version - Media version- MIME - Accept Header - Content negotiation -
	// GIT
	@GetMapping(value = "person/produces", produces = "application/vnd.api-v1+json")
	public UserV1 dGetPersonV1Producer() {
		return new UserV1("Viswanath Ammiraju");
	}

	@GetMapping(value = "person/produces", produces = "application/vnd.api-v2+json")
	public UserV2 dGetPersonV2Producer() {
		return new UserV2(new Name("Viswanath", "Ammiraju"));
	}
}

record UserV1(String name) {
}

record UserV2(Name name) {
}

record Name(String firstName, String SecondName) {
}