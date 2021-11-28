package com.vis.learning.user.withoutjpa;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public record User(@NotNull Integer id, @NotNull @Size(min = 2, max = 100) String name,
		@NotNull @Past Date dateOfBirth) {

}
