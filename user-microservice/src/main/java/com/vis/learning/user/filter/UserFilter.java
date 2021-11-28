package com.vis.learning.user.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFilter("dynamicFilterAtUserFilter")
@JsonIgnoreProperties(value = { "gender", "secondName" })
public record UserFilter(String firstName, String secondName, String gender, String address, String phone, String email,
		@JsonIgnore String password) {
}
