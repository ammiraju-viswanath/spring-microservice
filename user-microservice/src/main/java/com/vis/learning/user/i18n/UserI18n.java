package com.vis.learning.user.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserI18n {
	@Autowired
	MessageSource messageSource;

	@GetMapping("/user/I18n") // Customisation based on Language by adding message.properties
	public String firstAppWithI18n() {
		return messageSource.getMessage("first.message", null, "Default message here", LocaleContextHolder.getLocale());
	}
}
