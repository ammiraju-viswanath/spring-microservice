package com.vis.learning.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice-details")
public class Configuration {
	private String currencyExchange;
	private String currencyConversion;

	private String eureka;
	private String apiCurrencyExchange;
	private String apiCurrencyConversion;

	public Configuration() {
	}

	public Configuration(String currencyExchange, String currencyConversion, String eureka, String apiCurrencyExchange,
			String apiCurrencyConversion) {
		this.currencyExchange = currencyExchange;
		this.currencyConversion = currencyConversion;
		this.eureka = eureka;
		this.apiCurrencyExchange = apiCurrencyExchange;
		this.apiCurrencyConversion = apiCurrencyConversion;
	}

	public String getApiCurrencyConversion() {
		return apiCurrencyConversion;
	}

	public String getApiCurrencyExchange() {
		return apiCurrencyExchange;
	}

	public String getCurrencyConversion() {
		return currencyConversion;
	}

	public String getCurrencyExchange() {
		return currencyExchange;
	}

	public String getEureka() {
		return eureka;
	}

	public void setApiCurrencyConversion(String apiCurrencyConversion) {
		this.apiCurrencyConversion = apiCurrencyConversion;
	}

	public void setApiCurrencyExchange(String apiCurrencyExchange) {
		this.apiCurrencyExchange = apiCurrencyExchange;
	}

	public void setCurrencyConversion(String currencyConversion) {
		this.currencyConversion = currencyConversion;
	}

	public void setCurrencyExchange(String currencyExchange) {
		this.currencyExchange = currencyExchange;
	}

	public void setEureka(String eureka) {
		this.eureka = eureka;
	}

}
