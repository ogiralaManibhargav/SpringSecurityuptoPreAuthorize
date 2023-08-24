package com.springsecurity.controller;

import com.springsecurity.entity.Customer;
import com.springsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        if (customer != null && customer.getEmail()!=null ) {
            try {
                customer.setPwd(passwordEncoder.encode(customer.getPwd()));
                customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));

                savedCustomer = repository.save(customer);
            } catch (Exception e) {
                throw new RuntimeException(e + "Exception happend during runtime");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer details are saved Sucessfully");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customer details are not saved Sucessfully");

    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = repository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }

    }

}
