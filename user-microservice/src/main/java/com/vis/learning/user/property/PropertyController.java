package com.vis.learning.user.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

	@Autowired
	PropertyFromClass myconfig;

	@Autowired
	Environment enviornment;

	@GetMapping("/fromPropertyFile")
	public PropertyFromClass getFromApplicationConfiguration() {
		return new PropertyFromClass(myconfig.getKey1(), myconfig.getKey2(),
				enviornment.getProperty("local.server.port"));
	}

	@GetMapping("/hardCoded")
	public PropertyFromClass getHardCodedValues() {
		return new PropertyFromClass("1", "first");
	}

}
