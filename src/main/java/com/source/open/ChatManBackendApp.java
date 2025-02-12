package com.source.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

//@formatter:off
@OpenAPIDefinition(
	info = @Info(
		title = "chat man backend", 
		description = "A chat server for chat man frontend | REST API Documentation", 
		version = "v1.0", 
		contact = @Contact(name = "Naresh Kumar", email = "nareshkumar73@protonmail.com")))
//@formatter:on
@SpringBootApplication
public class ChatManBackendApp {

	public static void main(String[] args) {
		SpringApplication.run(ChatManBackendApp.class, args);
	}

}
