package com.vis.learning.user.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserFilterController {

	@GetMapping("/dynamicfilering")
	public MappingJacksonValue dynamicfileringType() {
		// Lets further filter phone.
		final var myBean = new UserFilter("firstName value", "secondName value", "gender value", "addrerss value",
				"phone value", "email value", "password Value");

		final var mjv = new MappingJacksonValue(myBean);
		final FilterProvider filter = new SimpleFilterProvider().addFilter("dynamicFilterAtUserFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("phone"));
		mjv.setFilters(filter);
		return mjv;

	}

	@GetMapping("/staticfilering")
	public UserFilter staticFiltering() {
		return new UserFilter(" firstName value", " secondName value", " gender value", "addrerss value", "phone value",
				"email value", "password Value");

	}

}
