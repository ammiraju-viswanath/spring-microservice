package com.vis.learning.user.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice-details")
public class PropertyFromClass {
	private String key1;
	private String key2;

	private String port;

	public PropertyFromClass() {
	}

	public PropertyFromClass(String key1, String key2) {
		this.key1 = key1;
		this.key2 = key2;
	}

	public PropertyFromClass(String key1, String key2, String port) {
		this.key1 = key1;
		this.key2 = key2;
		this.port = port;
	}

	public String getKey1() {
		return key1;
	}

	public String getKey2() {
		return key2;
	}

	public String getPort() {
		return port;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
