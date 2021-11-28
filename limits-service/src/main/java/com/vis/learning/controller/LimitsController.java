package com.vis.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vis.learning.bean.Limits;
import com.vis.learning.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(new String[] { configuration.getCurrencyExchange(), configuration.getCurrencyConversion(),
				configuration.getEureka(), configuration.getApiCurrencyExchange(),
				configuration.getApiCurrencyConversion() });

	}
}
