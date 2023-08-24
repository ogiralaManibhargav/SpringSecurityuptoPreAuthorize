package com.springsecurity.repository;

import com.springsecurity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository< Customer,Integer> {
    List<Customer> findByEmail(String username);

    boolean existsByEmail(String email);
}
