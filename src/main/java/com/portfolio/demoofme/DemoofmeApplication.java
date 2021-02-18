package com.portfolio.demoofme;

import com.portfolio.demoofme.email.SendEmail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
public class DemoofmeApplication {

	public static void main(String[] args) throws MessagingException {
//		SendEmail sm = new SendEmail();
//		sm.sendMail("Somebody", "Somebody is on my site");
		SpringApplication.run(DemoofmeApplication.class, args);
	}

}


/*
vlhzmhvkiadypplm
Пароль с которым это приложение может посылать емайлы

server.port=80
spring.datasource.url=jdbc:postgresql://35.228.8.59/postgres
spring.datasource.username=postgres
spring.datasource.password=klop0987
spring.datasource.driver-class-name=org.postgresql.Driver
 */
