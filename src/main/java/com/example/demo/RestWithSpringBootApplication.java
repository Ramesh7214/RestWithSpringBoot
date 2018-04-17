package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.gbn.config.SwaggerConfig;

@SpringBootApplication
@ComponentScan({"com.gbn.helloworld.controller","com.gbn.user.controller","com.gbn.user.service","com.gbn.user.exception"})
@Import(SwaggerConfig.class)
public class RestWithSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootApplication.class, args);
	System.out.println("hello hello");
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasename("messages");
		return rb;
	}
	
}
