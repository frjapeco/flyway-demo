package com.billib.flywaydemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billib.flywaydemo.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
