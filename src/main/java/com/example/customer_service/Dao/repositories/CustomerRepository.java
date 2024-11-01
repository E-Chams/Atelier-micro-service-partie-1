package com.example.customer_service.Dao.repositories;

import com.example.customer_service.Dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
