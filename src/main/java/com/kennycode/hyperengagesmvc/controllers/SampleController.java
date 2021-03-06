package com.kennycode.hyperengagesmvc.controllers;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	@Autowired
	private MessageSource messageSource;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hi quiin, welcome to JAVA EE";

	@RequestMapping("/")
	public String welcome(Locale locale, Model model) {

		// add parametrized message from controller
		// String welcome = messageSource.getMessage("welcome.message", new Object[] {
		// "K3nny C0d3" }, locale);
		// model.addAttribute("message", welcome);
		// obtain locale from LocaleContextHolder
		// Locale currentLocale = LocaleContextHolder.getLocale();
		// model.addAttribute("locale", currentLocale);
		// model.addAttribute("startMeeting", "10:30");

		return "welcome";
	}

	@RequestMapping("/aboutus")
	public String aboutus(Map<String, Object> model) {
		model.put("message", this.message);
		return "aboutus";
	}
	
/*	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Error> handle(RuntimeException ex) {
		System.out.println("controller local exception handling @ExceptionHandler");
		Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
}
