package com.gbn.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gbn.helloworld.model.HelloWorld;

@RestController
public class HelloWorldController {
	
	@Autowired
	public MessageSource messageSource;

	// returning plain text

	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		return "Hello World !!";
	}
	
	
	// returning plain text
	//(name = "Accept-Launguage", required=false) - if accept-language empty take default

	/*@GetMapping(path = "/helloWorldI18N")
	public String helloWorldI18N(@RequestHeader(name = "Accept-Language", required=false) Locale local) {
		return messageSource.getMessage("goodmorning", null,local);
	}*/
	
	
	//I18N improved
	
	@GetMapping(path = "/helloWorldI18N")
	public String helloWorldI18N() {
		return messageSource.getMessage("goodmorning", null,LocaleContextHolder.getLocale());
	}

	// returning bean

	@GetMapping(path = "/helloWorldBean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World");
	}

	// Path variable

	@GetMapping(path = "/helloWorldBean/{message}")
	public HelloWorld helloWorldBeanWithPathVar(@PathVariable String message) {
		return new HelloWorld(message);
	}

}
