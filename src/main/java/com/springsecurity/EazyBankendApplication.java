package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity(debug = true)
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class EazyBankendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankendApplication.class, args);
	}

}
/*
* {

	 "email":"manib@gmail.com",
     "pwd":"123",
	 "role":
         "Admin"


}
*
*
* {

	 "email":"john@example.com",
     "mobileNumber":"1234567890",
     "name":"johny123",
     "pwd":123,
     "role":"user"

}
* */